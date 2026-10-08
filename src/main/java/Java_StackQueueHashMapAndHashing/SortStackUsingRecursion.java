/*
2. Sort a Stack Using Recursion
Problem: Given a stack, sort its elements in ascending order using recursion.
Hint: Pop elements recursively, sort the remaining stack, and insert the popped element back at the correct position.
 */

package Java_StackQueueHashMapAndHashing;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class SortStackUsingRecursion {

    Stack<Integer> stack = new Stack<>();

    void SortTheStack(){
        if (stack.isEmpty()){
            return;
        }

        int temp = stack.pop();

        SortTheStack();
        InsertInStack(temp);
    }

    void InsertInStack(int val){

        if (stack.isEmpty()){
            stack.push(val);
            return;
        }

        if (stack.peek() > val){
            int temp2 = stack.pop();
            InsertInStack(val);
            stack.push(temp2);
        }else{
            stack.push(val);
        }

    }


    public static void main(String[] args) {

        SortStackUsingRecursion sort = new SortStackUsingRecursion();

        sort.stack.push(5);
        sort.stack.push(4);
        sort.stack.push(6);
        sort.stack.push(9);
        System.out.println(sort.stack);
        sort.SortTheStack();
        System.out.println(sort.stack);
    }
}