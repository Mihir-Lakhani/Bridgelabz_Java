// Syllabus practical: Unique common values in first-list encounter order.
package Java_Collections.PracticeProblems;

import java.util.*;

public class CommonElementsBetweenLists {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(3, 1, 2, 2);
        List<Integer> b = Arrays.asList(2, 3, 3, 5);
        Set<Integer> membership = new HashSet<>(b);
        Set<Integer> common = new LinkedHashSet<>();
        for (int value : a) {
            if (membership.contains(value)) common.add(value);
        }
        System.out.println(common);
    }
}
