package Java_Collections.Map;

import java.util.*;
import java.time.LocalDate;
import Java_Collections.Models.Policy;

// Map 6: primary number lookup, insertion order and a grouped expiry-date index.
public class InsurancePolicyManagementSystem {

    private final Map<String, Policy> lookup = new HashMap<>();
    private final Map<String, Policy> insertionOrder = new LinkedHashMap<>();
    private final NavigableMap<LocalDate, List<Policy>> byExpiry = new TreeMap<>();

    void addPolicy(Policy policy) {
        lookup.put(policy.number, policy);
        insertionOrder.put(policy.number, policy);
        rebuildExpiryIndex();
    }

    private void rebuildExpiryIndex() {
        byExpiry.clear();
        for (Policy policy : insertionOrder.values()) {
            byExpiry.computeIfAbsent(policy.expiry, date -> new ArrayList<>()).add(policy);
        }
    }

    Policy getPolicy(String number) { return lookup.get(number); }

    List<Policy> expiringSoon(LocalDate today) {
        List<Policy> result = new ArrayList<>();
        for (List<Policy> group : byExpiry.subMap(today, true, today.plusDays(30), true).values()) {
            result.addAll(group);
        }
        return result;
    }

    List<Policy> forPolicyholder(String holder) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : insertionOrder.values()) {
            if (policy.holder.equalsIgnoreCase(holder)) result.add(policy);
        }
        return result;
    }

    int removeExpired(LocalDate today) {
        int removed = 0;
        Iterator<Policy> iterator = insertionOrder.values().iterator();
        while (iterator.hasNext()) {
            Policy policy = iterator.next();
            if (policy.expiry.isBefore(today)) {
                lookup.remove(policy.number);
                iterator.remove();
                removed++;
            }
        }
        rebuildExpiryIndex();
        return removed;
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();
        LocalDate today = LocalDate.now();
        system.addPolicy(new Policy("P2", "Mihir", today.plusDays(10), "Auto", 2000));
        system.addPolicy(new Policy("P1", "Asha", today.plusDays(10), "Health", 1000));
        system.addPolicy(new Policy("P3", "Mihir", today.minusDays(1), "Home", 3000));
        System.out.println("Lookup: " + system.getPolicy("P2"));
        System.out.println("Insertion order: " + system.insertionOrder.values());
        System.out.println("Expiry order: " + system.byExpiry);
        System.out.println("Expiring soon: " + system.expiringSoon(today));
        System.out.println("Mihir's policies: " + system.forPolicyholder("Mihir"));
        System.out.println("Expired removed: " + system.removeExpired(today));
        System.out.println("Remaining expiry index: " + system.byExpiry);
    }
}
