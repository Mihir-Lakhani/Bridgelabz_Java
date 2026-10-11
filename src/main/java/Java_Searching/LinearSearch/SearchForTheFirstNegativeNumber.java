/*
Linear Search Problem 1: Search for the First Negative Number
Problem:
You are given an integer array. Write a program that performs Linear Search to find the first negative number in the array. If a negative number is found, return its index. If no negative number is found, return -1.
Approach:
1. Iterate through the array from the start.
2. Check if the current element is negative.
3. If a negative number is found, return its index.
4. If the loop completes without finding a negative number, return -1.
 */

package Java_Searching.LinearSearch;

public class SearchForTheFirstNegativeNumber {

    static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 0, 7, -3, -8, 2};
        System.out.println("First negative number index: " + findFirstNegative(arr));
    }
}
