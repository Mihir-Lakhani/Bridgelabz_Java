// Syllabus practical: Maintain a min-heap of the k largest occurrences.
package Java_Collections.PracticeProblems;

import java.util.*;

public class KthLargestElement {
    static int kthLargest(int[] values, int k) {
        if (k <= 0 || k > values.length) {
            throw new IllegalArgumentException("Invalid k");
        }
        Queue<Integer> heap = new PriorityQueue<>();
        for (int value : values) {
            heap.offer(value);
            if (heap.size() > k) heap.poll();
        }
        return heap.element();
    }

    public static void main(String[] args) {
        int[] values = {3, 1, 5, 5, 2};
        System.out.println(kthLargest(values, 2));
    }
}
