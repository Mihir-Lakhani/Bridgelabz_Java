/*
Find All Subarrays with Zero Sum
Problem: Given an array, find all subarrays whose elements sum up to zero.
Hint: Use a hash map to store the cumulative sum and its frequency. If a sum repeats, a zero-sum subarray exists.
 */

package Java_StackQueueHashMapAndHashing.HashMapAndHashing;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


public class SubArraySumK {

    static int findSubArrays(int[] arr, int k){

        HashMap<Integer, Integer> presumHash = new HashMap<>();
        int result=0;
        presumHash.put(0, 1);
        int presum = 0;
        for(int i = 0; i < arr.length; i++){
            presum += arr[i];

            result += presumHash.getOrDefault(presum-k, 0);

            presumHash.put(presum,
                    presumHash.getOrDefault(presum, 0) + 1);

            //put(key, value)
        }

        return result;
    }


    public static void main(String[] args) {

        int[] arr = {1, -1, 2};
        int ans = findSubArrays(arr, 0);
        System.out.println(ans);

    }
}