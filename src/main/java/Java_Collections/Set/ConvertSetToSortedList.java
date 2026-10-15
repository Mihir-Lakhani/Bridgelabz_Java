package Java_Collections.Set;

import java.util.*;

// Set 4: copy HashSet elements into an ascending list.
public class ConvertSetToSortedList {

    static List<Integer> sortedList(Set<Integer> values) {
        List<Integer> result = new ArrayList<>(values);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sortedList(new HashSet<>(Arrays.asList(5, 3, 9, 1))));
    }
}
