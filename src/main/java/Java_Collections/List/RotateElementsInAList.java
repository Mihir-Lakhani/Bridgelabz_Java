package Java_Collections.List;

import java.util.*;

// List 3: rotate left, as in the assignment example.
public class RotateElementsInAList {

    static <T> void rotateLeft(List<T> list, int positions) {
        if (list.isEmpty()) return;
        int shift = Math.floorMod(positions, list.size());
        List<T> rotated = new ArrayList<>(list.size());
        rotated.addAll(list.subList(shift, list.size()));
        rotated.addAll(list.subList(0, shift));
        ListIterator<T> iterator = list.listIterator();
        for (T value : rotated) {
            iterator.next();
            iterator.set(value);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        rotateLeft(numbers, 2);
        System.out.println(numbers);
    }
}
