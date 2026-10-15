// Syllabus practical: Min and max in a nonempty collection.
package Java_Collections.PracticeProblems;

import java.util.*;

public class HighestAndLowestValues {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(7, -2, 9, 4);
        if (!values.isEmpty()) {
            System.out.println(Collections.min(values));
            System.out.println(Collections.max(values));
        }
    }
}
