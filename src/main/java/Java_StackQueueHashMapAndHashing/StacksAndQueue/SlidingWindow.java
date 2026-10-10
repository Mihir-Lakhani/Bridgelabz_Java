/*
Sliding Window Maximum
Problem: Given an array and a window size k, find the maximum element in each sliding window of size k.
Hint: Use a deque (double-ended queue) to maintain indices of useful elements in each window.
 */

package Java_StackQueueHashMapAndHashing.StacksAndQueue;

import java.util.*;

public class SlidingWindow {

    static int[] findMaximums(int[] arr, int k){
        if (arr == null || k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Invalid array or window size");
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[arr.length - k + 1];
        for (int i=0; i<arr.length; i++){

            while(!deque.isEmpty() && deque.peekFirst() < i-k+1){
                deque.pollFirst();
            }



            while(!deque.isEmpty() && arr[deque.peekLast()] < arr[i]){
                deque.pollLast();
            }
            deque.offer(i);


            if (i >= k - 1) {
                ans[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        int[] arr = {3,1,2,0,5};
        int[] ans = findMaximums(arr, 3);
        System.out.println(Arrays.toString(ans));
    }
}