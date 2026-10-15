package Java_Collections.List;

import java.util.*;

// List 4: keep the first occurrence of each element.
public class RemoveDuplicatesPreservingOrder {

    static <T> List<T> removeDuplicates(List<T> values) {
        return new ArrayList<>(new LinkedHashSet<>(values));
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(Arrays.asList(3, 1, 2, 2, 3, 4)));
    }
}
