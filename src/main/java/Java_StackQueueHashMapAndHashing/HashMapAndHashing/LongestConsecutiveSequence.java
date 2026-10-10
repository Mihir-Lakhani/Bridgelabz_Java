package Java_StackQueueHashMapAndHashing.HashMapAndHashing;

import java.util.*;

public class LongestConsecutiveSequence {

    static int findTheLengthOfSequence(int[] arr){

        HashMap<Integer, Boolean> values = new HashMap<>();

        for(int num: arr){
            values.put(num, true);
        }

        int n = 0;
        int m = 0;

        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            n=1;
            if (values.get(num-1) == null){

                while (values.get(num + 1) != null){
                    num++;
                    n++;
                }
            }
            m = Math.max(n, m);
        }
        return m;
    }


    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2, 6, 5 };

        int length = findTheLengthOfSequence(arr);

        System.out.println("Longest consecutive sequence length: " + length);
        // Expected: 4
    }
}