/*
Challenge Problem (for both Linear and Binary Search)
Problem:
You are given a list of integers. Write a program that uses Linear Search to find the first missing positive integer in the list and Binary Search to find the index of a given target number.
Approach:
Linear Search for the first missing positive integer:
Iterate through the list and mark each number in the list as visited (you can use negative marking or a separate array).
Traverse the array again to find the first positive integer that is not marked.
Binary Search for the target index:
After sorting the array, perform binary search to find the index of the given target number.
Return the index if found, otherwise return -1.
 */

package Java_Searching;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ChallengeProblem {

    public static int findTheMissingNumber(int[] arr) {
        int n = arr.length;
        int[] marking = new int[n + 1];

        for (int num : arr) {
            if (num >= 1 && num <= n) {
                marking[num] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (marking[i] == 0) {
                return i;
            }
        }

        return n + 1;
    }

    public static int findTargetIndex(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {4,5,7,-1,3};
        int target = 3;
        int missingNumber = findTheMissingNumber(arr);
        System.out.println("First missing positive integer: " + missingNumber);

        Arrays.sort(arr);
        int targetIndex = findTargetIndex(arr, target);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Target index in sorted array: " + targetIndex);
    }
}
