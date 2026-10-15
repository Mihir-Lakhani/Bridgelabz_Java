// Syllabus practical: FIFO end choices.
package Java_Collections.PracticeProblems;

import java.util.*;

public class QueueUsingDeque {
    public static void main(String[] args) {
        Deque<String> queue = new ArrayDeque<>();
        queue.offerLast("first"); queue.offerLast("second");
        while (!queue.isEmpty()) System.out.println(queue.pollFirst());
    }
}
