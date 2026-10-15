package Java_Collections.List;

import java.util.*;

// List 2: count strings and return Map<String, Integer>.
public class FrequencyOfElements {

    static Map<String, Integer> frequencies(List<String> words) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : words) counts.put(word, counts.getOrDefault(word, 0) + 1);
        return counts;
    }

    public static void main(String[] args) {
        System.out.println(frequencies(Arrays.asList("apple", "banana", "apple", "orange")));
    }
}
