package Java_Collections.Queue;

import java.util.*;

// Queue 4: push, pop and top using two FIFO queues.
public class StackUsingTwoQueues {

    static class TwoQueueStack<T> {
        private Queue<T> active = new ArrayDeque<>();
        private Queue<T> helper = new ArrayDeque<>();

        void push(T value) {
            helper.offer(value);
            while (!active.isEmpty()) helper.offer(active.remove());
            Queue<T> temporary = active;
            active = helper;
            helper = temporary;
        }

        T pop() { return active.poll(); } // null if empty
        T top() { return active.peek(); }
        boolean isEmpty() { return active.isEmpty(); }
    }

    public static void main(String[] args) {
        TwoQueueStack<Integer> stack = new TwoQueueStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top after pop: " + stack.top());
    }
}
