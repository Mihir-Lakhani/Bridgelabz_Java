// Syllabus practical: Count first, then find the first count-one key.
package Java_Collections.PracticeProblems;

import java.util.*;
import java.util.stream.*;

public class FirstNonRepeatedElement {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("A", "B", "A", "C", "D", "C");
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String value : input) counts.merge(value, 1, Integer::sum);
        Optional<String> answer = counts.entrySet().stream()
            .filter(e -> e.getValue() == 1)
            .map(Map.Entry::getKey).findFirst();
        System.out.println(answer.orElse("None"));
    }
}
