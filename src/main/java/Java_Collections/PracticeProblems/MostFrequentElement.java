// Syllabus practical: Frequency maximum with an explicit tie rule.
package Java_Collections.PracticeProblems;

import java.util.*;

public class MostFrequentElement {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("B", "A", "A", "B", "C");
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String value : input) counts.merge(value, 1, Integer::sum);
        String answer = null;
        int maximum = 0;
        for (Map.Entry<String, Integer> e : counts.entrySet()) {
            if (e.getValue() > maximum) {
                maximum = e.getValue(); answer = e.getKey();
            }
        }
        System.out.println(answer);
    }
}
