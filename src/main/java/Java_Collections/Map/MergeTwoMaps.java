package Java_Collections.Map;

import java.util.*;

// Map 4: sum values for common keys, retaining both input maps.
public class MergeTwoMaps {

    static <K> Map<K, Integer> merge(Map<K, Integer> first, Map<K, Integer> second) {
        Map<K, Integer> result = new LinkedHashMap<>(first);
        second.forEach((key, value) -> result.merge(key, value, Integer::sum));
        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> first = new LinkedHashMap<>();
        first.put("A", 1);
        first.put("B", 2);
        Map<String, Integer> second = new LinkedHashMap<>();
        second.put("B", 3);
        second.put("C", 4);
        System.out.println(merge(first, second));
    }
}
