package Java_Collections.Queue;

import java.util.*;

// Queue 1: use only FIFO queue operations; no stack or reverse method.
public class ReverseAQueue {

    static <T> void reverse(Queue<T> queue) {
        Queue<T> temporary = new LinkedList<>();
        int remaining = 0;
        while (!queue.isEmpty()) {
            temporary.add(queue.remove());
            remaining++;
        }
        while (remaining > 0) {
            for (int i = 1; i < remaining; i++) temporary.add(temporary.remove());
            queue.add(temporary.remove());
            remaining--;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(10, 20, 30));
        reverse(queue);
        System.out.println(queue);
    }
}
