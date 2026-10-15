// Syllabus practical: TreeMap creates a key-sorted view of copied associations.
package Java_Collections.PracticeProblems;

import java.util.*;

public class SortMapByKeys {
    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("C", 2); input.put("A", 3); input.put("B", 1);
        Map<String, Integer> sorted = new TreeMap<>(input);
        System.out.println(sorted);
    }
}
