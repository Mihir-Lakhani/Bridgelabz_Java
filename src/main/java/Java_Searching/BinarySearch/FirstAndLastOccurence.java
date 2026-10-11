/*
Binary Search Problem 4: Find the First and Last Occurrence of an Element in a Sorted Array
Problem:
Given a sorted array and a target element, write a program that uses Binary Search to find the first and last occurrence of the target element in the array. If the element is not found, return -1.
Approach:
Use binary search to find the first occurrence:
Perform a regular binary search, but if the target is found, continue searching on the left side (right = mid - 1) to find the first occurrence.
Use binary search to find the last occurrence:
Similar to finding the first occurrence, but once the target is found, continue searching on the right side (left = mid + 1) to find the last occurrence.
Return the indices of the first and last occurrence. If not found, return -1.
 */

package Java_Searching.BinarySearch;

public class FirstAndLastOccurence {

    static int findFirstOccurrence(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                answer = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    static int findLastOccurrence(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                answer = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;

        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);

        System.out.println("First occurrence: " + first);
        System.out.println("Last occurrence: " + last);
    }
}