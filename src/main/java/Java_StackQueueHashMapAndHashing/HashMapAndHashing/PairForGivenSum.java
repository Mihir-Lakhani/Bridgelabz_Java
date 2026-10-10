/*
Check for a Pair with Given Sum in an Array
Problem: Given an array and a target sum, find if there exists a pair of elements whose sum is equal to the target.
Hint: Store visited numbers in a hash map and check if target - current_number exists in the map.
 */

package Java_StackQueueHashMapAndHashing.HashMapAndHashing;

import java.util.HashMap;
import java.util.Scanner;

public class PairForGivenSum {

    static int findPairs(int[] arr, int sum){

        int result = 0;

        HashMap<Integer, Integer> values = new HashMap<>();

        for (int i = 0; i < arr.length; i++){

            result += values.getOrDefault(sum - arr[i], 0);

            values.put(arr[i], values.getOrDefault(arr[i], 0) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 4, 5};
        int target = 6;

        int count = findPairs(arr, target);

        System.out.println("Number of pairs: " + count); // 2
        System.out.println("Pair exists: " + (count > 0)); // true
    }
}