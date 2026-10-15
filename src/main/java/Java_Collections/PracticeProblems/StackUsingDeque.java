// Syllabus practical: LIFO end choices.
package Java_Collections.PracticeProblems;

import java.util.*;

public class StackUsingDeque {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("first"); stack.push("second");
        System.out.println(stack.peek());
        while (!stack.isEmpty()) System.out.println(stack.pop());
    }
}
