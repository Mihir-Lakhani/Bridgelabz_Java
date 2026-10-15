package Java_Collections.List;

import java.util.*;

// List 5: find the Nth element from the end without size().
public class NthElementFromEnd {

    static <T> T nthFromEnd(LinkedList<T> list, int n) {
        if (n <= 0) return null;
        Iterator<T> leading = list.iterator();
        Iterator<T> following = list.iterator();
        for (int i = 0; i < n; i++) {
            if (!leading.hasNext()) return null;
            leading.next();
        }
        while (leading.hasNext()) {
            leading.next();
            following.next();
        }
        return following.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println(nthFromEnd(list, 2));
    }
}
