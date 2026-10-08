/*
3. Stock Span Problem
Problem: For each day in a stock price array, calculate the span (number of consecutive days the price was less than or equal to the current day's price).
Hint: Use a stack to keep track of indices of prices in descending order.
 */

package Java_StackQueueHashMapAndHashing;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {

    Stack<Integer> prices = new Stack<>();
    Stack<Integer> spans = new Stack<>();
    Stack<Integer> temp = new Stack<>();

    void FindTheSpan(){
        int span = 1;

        int today = prices.peek();
        span = logic(today, span);

        invertPush(span);
    }

    int logic(int top, int span){
        int temp;
        temp = prices.pop();

        if (!prices.isEmpty() && prices.peek() <= top){
            span++;
            span = logic(top, span);
        }
        prices.push(temp);
        return span;

    }

    void invertPush(int val){
        while(!spans.isEmpty()){
            temp.push(spans.pop());
        }
        spans.push(val);
        while(!temp.isEmpty()){
            spans.push(temp.pop());
        }
    }


    public static void main(String[] args) {

        StockSpanProblem stack = new StockSpanProblem();

        stack.prices.push(100);
        stack.prices.push(80);
        stack.prices.push(60);
        stack.prices.push(70);
        stack.prices.push(60);
        stack.prices.push(75);
        stack.prices.push(85);

        System.out.println(stack.prices);
        int size = stack.prices.size();
        for(int i = 0; i< size; i++){
            stack.FindTheSpan();
            stack.prices.pop();
        }

        System.out.println(stack.spans);
    }
}


/*
import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

    static int[] findSpans(int[] prices) {
        int[] spans = new int[prices.length];
        Stack<Integer> indices = new Stack<>();

        for (int i = 0; i < prices.length; i++) {

            // Remove previous days whose prices cannot stop today's span.
            while (!indices.isEmpty()
                    && prices[indices.peek()] <= prices[i]) {
                indices.pop();
            }

            if (indices.isEmpty()) {
                spans[i] = i + 1;
            } else {
                spans[i] = i - indices.peek();
            }

            indices.push(i);
        }

        return spans;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        System.out.println(Arrays.toString(findSpans(prices)));
    }
}
 */