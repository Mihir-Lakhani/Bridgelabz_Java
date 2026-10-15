package Java_Collections.Map;

import java.util.*;

// Map 2: duplicate values require Map<V, List<K>>, preserving every original key.
public class InvertAMap {

    static <K, V> Map<V, List<K>> invert(Map<K, V> input) {
        Map<V, List<K>> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : input.entrySet()) {
            result.computeIfAbsent(entry.getValue(), key -> new ArrayList<>()).add(entry.getKey());
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Integer> input = new LinkedHashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 1);
        System.out.println(invert(input));
    }
}
