package Java_Collections.Set;

import java.util.*;
import java.time.LocalDate;
import Java_Collections.Models.Policy;

// Set 6: unique policies, expiry order, filters, duplicates and performance.
public class InsurancePolicyManagementSystem {

    private final Set<Policy> lookup = new HashSet<>();
    private final Set<Policy> insertionOrder = new LinkedHashSet<>();
    // The tree is a secondary index of canonical policies. The number breaks expiry ties.
    private final Set<Policy> expiryOrder = new TreeSet<>(
            Comparator.comparing((Policy p) -> p.expiry).thenComparing(p -> p.number));
    private final Set<String> duplicateNumbers = new LinkedHashSet<>();

    boolean addPolicy(Policy policy) {
        if (!lookup.add(policy)) {
            duplicateNumbers.add(policy.number);
            return false; // Keep the first record with this policy number in all three sets.
        }
        insertionOrder.add(policy);
        expiryOrder.add(policy);
        return true;
    }

    Policy findByNumber(String number) {
        for (Policy policy : lookup) if (policy.number.equals(number)) return policy;
        return null;
    }

    boolean removePolicy(String number) {
        Policy policy = findByNumber(number);
        if (policy == null) return false;
        lookup.remove(policy);
        insertionOrder.remove(policy);
        expiryOrder.remove(policy);
        return true;
    }

    List<Policy> expiringSoon(LocalDate today) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : expiryOrder) {
            if (!policy.expiry.isBefore(today) && !policy.expiry.isAfter(today.plusDays(30))) {
                result.add(policy);
            }
        }
        return result;
    }

    List<Policy> withCoverage(String coverage) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : insertionOrder) {
            if (policy.coverage.equalsIgnoreCase(coverage)) result.add(policy);
        }
        return result;
    }

    static void benchmark(String label, Set<Policy> set, List<Policy> input) {
        long start = System.nanoTime();
        set.addAll(input);
        long added = System.nanoTime();
        int found = 0;
        for (Policy policy : input) if (set.contains(policy)) found++;
        long searched = System.nanoTime();
        for (Policy policy : input) set.remove(policy);
        long removed = System.nanoTime();
        System.out.println(label + " (ns): add=" + (added - start)
                + ", search=" + (searched - added) + ", remove=" + (removed - searched)
                + ", found=" + found);
    }

    static void comparePerformance() {
        List<Policy> input = new ArrayList<>();
        LocalDate date = LocalDate.of(2026, 10, 16);
        for (int i = 0; i < 10000; i++) {
            input.add(new Policy("P" + i, "Holder", date.plusDays(i % 60), "Health", 1000));
        }
        Comparator<Policy> order = Comparator.comparing((Policy p) -> p.expiry)
                .thenComparing(p -> p.number);
        // Simple demonstration only; JVM warm-up and scheduling affect elapsed timings.
        benchmark("HashSet", new HashSet<>(), input);
        benchmark("LinkedHashSet", new LinkedHashSet<>(), input);
        benchmark("TreeSet", new TreeSet<>(order), input);
        System.out.println("Expected add/contains/remove: hash sets O(1), TreeSet O(log n).");
        System.out.println("findByNumber scans policy objects here: O(n).");
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();
        LocalDate today = LocalDate.now();
        system.addPolicy(new Policy("P2", "Mihir", today.plusDays(10), "Auto", 2000));
        system.addPolicy(new Policy("P1", "Asha", today.plusDays(10), "Health", 1000));
        system.addPolicy(new Policy("P3", "Mihir", today.minusDays(1), "Home", 3000));
        system.addPolicy(new Policy("P2", "Mihir", today.plusDays(40), "Auto", 2000));
        System.out.println("Unique policies: " + system.lookup.size());
        System.out.println("Insertion order: " + system.insertionOrder);
        System.out.println("Expiry order: " + system.expiryOrder);
        System.out.println("Duplicates: " + system.duplicateNumbers);
        System.out.println("Expiring within 30 days: " + system.expiringSoon(today));
        System.out.println("Health policies: " + system.withCoverage("Health"));
        System.out.println("Find P2: " + system.findByNumber("P2"));
        System.out.println("Remove P3: " + system.removePolicy("P3"));
        comparePerformance();
    }
}
