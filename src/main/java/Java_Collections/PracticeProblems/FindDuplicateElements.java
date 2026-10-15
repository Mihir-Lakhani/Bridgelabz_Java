// Syllabus practical: Report each repeated value once.
package Java_Collections.PracticeProblems;

import java.util.*;

public class FindDuplicateElements {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4, 2);
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();
        for (int value : input) {
            if (!seen.add(value)) duplicates.add(value);
        }
        System.out.println(duplicates);
    }
}
