package Java_Collections.Set;

import java.util.*;

// Set 5: test whether every subset element belongs to the superset.
public class CheckSubset {

    static <T> boolean isSubset(Set<T> subset, Set<T> superset) {
        return superset.containsAll(subset);
    }

    public static void main(String[] args) {
        Set<Integer> subset = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> superset = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(isSubset(subset, superset));
    }
}
