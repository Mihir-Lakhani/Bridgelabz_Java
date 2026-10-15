package Java_Collections.List;

import java.util.*;

// List 1: reverse ArrayList and LinkedList without built-in reverse.
public class ReverseAList {

    static <T> void reverseArrayList(ArrayList<T> list) {
        for (int left = 0, right = list.size() - 1; left < right; left++, right--) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }

    static <T> void reverseLinkedList(LinkedList<T> list) {
        ListIterator<T> left = list.listIterator();
        ListIterator<T> right = list.listIterator(list.size());
        for (int i = 0; i < list.size() / 2; i++) {
            T first = left.next();
            T last = right.previous();
            left.set(last);
            right.set(first);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        reverseArrayList(arrayList);
        reverseLinkedList(linkedList);
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
    }
}
