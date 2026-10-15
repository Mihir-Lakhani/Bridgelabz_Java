// Syllabus practical: Remove nulls with a predicate.
package Java_Collections.PracticeProblems;

import java.util.*;

public class RemoveNullValues {
    public static void main(String[] args) {
        List<String> values = new ArrayList<>(
            Arrays.asList("A", null, "B", null));
        values.removeIf(Objects::isNull);
        System.out.println(values);
    }
}
