package Java_Collections.Set;

import java.util.*;

// Set 2: compute results without modifying either input.
public class UnionAndIntersection {

    static <T> Set<T> union(Set<T> first, Set<T> second) {
        Set<T> result = new LinkedHashSet<>(first);
        result.addAll(second);
        return result;
    }

    static <T> Set<T> intersection(Set<T> first, Set<T> second) {
        Set<T> result = new LinkedHashSet<>(first);
        result.retainAll(second);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> first = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> second = new LinkedHashSet<>(Arrays.asList(3, 4, 5));
        System.out.println("Union: " + union(first, second));
        System.out.println("Intersection: " + intersection(first, second));
    }
}
