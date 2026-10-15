package Java_Collections.Set;

import java.util.*;

// Set 1: compare membership regardless of insertion order.
public class CheckEqualSets {

    static <T> boolean areEqual(Set<T> first, Set<T> second) {
        return first.equals(second);
    }

    public static void main(String[] args) {
        Set<Integer> first = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> second = new LinkedHashSet<>(Arrays.asList(3, 2, 1));
        System.out.println(areEqual(first, second));
    }
}
