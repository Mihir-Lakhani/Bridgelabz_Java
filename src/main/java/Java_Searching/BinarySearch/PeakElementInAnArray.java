/*
Binary Search Problem 2: Find the Peak Element in an Array
Problem:
A peak element is an element that is greater than its neighbors. Write a program that performs Binary Search to find a peak element in an array. If there are multiple peak elements, return any one of them.
Approach:
Initialize left as 0 and right as n - 1.
Perform a binary search:
Find the middle element mid = (left + right) / 2.
If arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1], arr[mid] is a peak element.
If arr[mid] < arr[mid - 1], then search the left half, updating right = mid - 1.
If arr[mid] < arr[mid + 1], then search the right half, updating left = mid + 1.
Continue until a peak element is found.
 */

package Java_Searching.BinarySearch;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class PeakElementInAnArray {

    private static int FindThePeak(int[] arr){

        int n = arr.length;
        if (n == 1){
            return 0;
        }
        if (arr[0] > arr[1]){
            return 0;
        }
        if (arr[n-1] > arr[n-2]){
            return n-1;
        }

        int low = 1;
        int high = n-2;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]){
                return mid;
            }else if(arr[mid-1] < arr[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4};

        int index = FindThePeak(arr);

        if (index != -1) {
            System.out.println("Peak index: " + index);
            System.out.println("Peak value: " + arr[index]);
        } else {
            System.out.println("No peak found");
        }
    }
}