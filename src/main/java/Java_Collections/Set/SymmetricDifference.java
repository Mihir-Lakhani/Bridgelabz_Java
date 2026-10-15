package Java_Collections.Set;

import java.util.*;

// Set 3: elements in either set but not both.
public class SymmetricDifference {

    static <T> Set<T> symmetricDifference(Set<T> first, Set<T> second) {
        Set<T> result = new LinkedHashSet<>(first);
        result.addAll(second);
        Set<T> common = new HashSet<>(first);
        common.retainAll(second);
        result.removeAll(common);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> first = new LinkedHashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> second = new LinkedHashSet<>(Arrays.asList(3, 4, 5));
        System.out.println(symmetricDifference(first, second));
    }
}
