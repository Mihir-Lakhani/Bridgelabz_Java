// Syllabus practical: Sort entries, then preserve that sequence.
package Java_Collections.PracticeProblems;

import java.util.*;

public class SortMapByValues {
    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("C", 2); input.put("A", 2); input.put("B", 1);
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(
            input.entrySet());
        entries.sort(Map.Entry.<String, Integer>comparingByValue()
            .thenComparing(Map.Entry.comparingByKey()));
        Map<String, Integer> sorted = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> e : entries) {
            sorted.put(e.getKey(), e.getValue());
        }
        System.out.println(sorted);
    }
}
