/*
Binary Search Problem 1: Find the Rotation Point in a Rotated Sorted Array
Problem:
You are given a rotated sorted array. Write a program that performs Binary Search to find the index of the smallest element in the array (the rotation point).
Approach:
Initialize left as 0 and right as n - 1.
Perform a binary search:
Find the middle element mid = (left + right) / 2.
If arr[mid] > arr[right], then the smallest element is in the right half, so update left = mid + 1.
If arr[mid] < arr[right], the smallest element is in the left half, so update right = mid.
Continue until left equals right, and then return arr[left] (the rotation point).
 */

package Java_Searching.BinarySearch;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class RotationPointInRotatedArray {


    private static int FindTheRotatingPoint(int[] arr, int low, int high){

        int mid = low + (high-low) /2;
        if(low<=high){

            if (arr[mid] > arr[high]){

                low = mid+1;
                low = FindTheRotatingPoint(arr, low, high);
            } else if (arr[mid] < arr[high]){

                high = mid;
                low = FindTheRotatingPoint(arr, low, high);
            }
        }
        return low;

    }


    public static void main(String[] args) {


        int[] arr = {6, 7, 8, 1, 2, 3, 4, 5};
        int index = FindTheRotatingPoint(arr, 0, arr.length-1);
        System.out.println(index);

    }
}