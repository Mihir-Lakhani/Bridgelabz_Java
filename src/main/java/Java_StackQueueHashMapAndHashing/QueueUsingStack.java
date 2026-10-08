/*
1. Implement a Queue Using Stacks
Problem: Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.
Hint: Use one stack for enqueue and another stack for dequeue. Transfer elements between stacks as needed.
 */

package Java_StackQueueHashMapAndHashing;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    void enqueue(int value){
        input.push(value);
    }

    void ifTransferNeeded(){

        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
    }

    int dequeue(){
        if (isEmpty()){
            System.out.println("Both the stacks are empty...returning -1");
            return -1;
        }
        ifTransferNeeded();

        return output.pop();
    }

    boolean isEmpty(){
        return input.isEmpty() && output.isEmpty();
    }

    Integer peek(){
        if (isEmpty()){
            System.out.println("Both the stacks are empty...cannot peek...returning null");
            return null;
        }
        ifTransferNeeded();

        return output.peek();
    }
    int size(){
        return input.size() + output.size();
    }


    public static void main(String[] args) {


        QueueUsingStack queue = new QueueUsingStack();

        queue.enqueue(5);
        queue.enqueue(6);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(9);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(6);
        queue.enqueue(4);

        System.out.println(queue.dequeue());

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());
        System.out.println(queue.peek());

    }
}