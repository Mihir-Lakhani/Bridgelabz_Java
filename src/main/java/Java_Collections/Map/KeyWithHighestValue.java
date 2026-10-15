package Java_Collections.Map;

import java.util.*;

// Map 3: highest integer value; retain the first encountered key on ties.
public class KeyWithHighestValue {

    static String highestValueKey(Map<String, Integer> values) {
        String best = null;
        int maximum = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            if (best == null || entry.getValue() > maximum) {
                best = entry.getKey();
                maximum = entry.getValue();
            }
        }
        return best; // null for an empty map; input keys and values are non-null.
    }

    public static void main(String[] args) {
        Map<String, Integer> values = new LinkedHashMap<>();
        values.put("A", 10);
        values.put("B", 20);
        values.put("C", 15);
        System.out.println(highestValueKey(values));
    }
}
