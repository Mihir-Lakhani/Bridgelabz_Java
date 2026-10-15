package Java_Collections.Queue;

import java.util.*;

// Queue 2: generate the first N binary strings, beginning with 1.
public class GenerateBinaryNumbers {

    static List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("1");
        for (int i = 0; i < n; i++) {
            String value = queue.remove();
            result.add(value);
            queue.offer(value + "0");
            queue.offer(value + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
