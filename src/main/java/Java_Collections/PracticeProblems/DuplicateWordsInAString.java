// Syllabus practical: Count tokens and select repeated words.
package Java_Collections.PracticeProblems;

import java.util.*;

public class DuplicateWordsInAString {
    public static void main(String[] args) {
        String input = "Java is fun. Java is useful!";
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String word : input.toLowerCase(Locale.ROOT)
                .split("[^\\p{L}\\p{N}]+")) {
            if (!word.isEmpty()) counts.merge(word, 1, Integer::sum);
        }
        counts.forEach((word, count) -> {
            if (count > 1) System.out.println(word + ": " + count);
        });
    }
}
