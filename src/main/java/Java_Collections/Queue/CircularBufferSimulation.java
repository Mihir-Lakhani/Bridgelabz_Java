package Java_Collections.Queue;

import java.util.*;

// Queue 5: fixed array queue, overwriting the oldest element when full.
public class CircularBufferSimulation {

    static class CircularBuffer {
        private final int[] data;
        private int head;
        private int size;

        CircularBuffer(int capacity) {
            if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
            data = new int[capacity];
        }

        void add(int value) {
            if (size < data.length) {
                data[(head + size) % data.length] = value;
                size++;
            } else {
                data[head] = value;
                head = (head + 1) % data.length;
            }
        }

        Integer remove() {
            if (size == 0) return null;
            int value = data[head];
            head = (head + 1) % data.length;
            size--;
            return value;
        }

        List<Integer> values() {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < size; i++) result.add(data[(head + i) % data.length]);
            return result;
        }
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.add(4);
        System.out.println(buffer.values());
        System.out.println("Removed: " + buffer.remove());
        System.out.println(buffer.values());
    }
}
