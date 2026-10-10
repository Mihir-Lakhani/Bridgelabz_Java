package Java_StackQueueHashMapAndHashing.HashMapAndHashing;

import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TwoSumProblem {

    static ArrayList<ArrayList<Integer>> FindTheIndices(int[] arr, int k){

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        ArrayList<ArrayList<Integer>> indices = new ArrayList<>();

        for (int i = 0; i < arr.length; i++){
            int partner = k - arr[i];
            if (map.containsKey(partner)){

                for(int j = 0; j < map.get(partner).size(); j++){
                    ArrayList<Integer> newRow = new ArrayList<>();
                    newRow.add(i);
                    ArrayList<Integer> partnerVal = map.get(partner);
                    newRow.add(partnerVal.get(j));
                    indices.add(newRow);
                }
            }
            ArrayList<Integer> row =  map.getOrDefault(arr[i], new ArrayList<>());
            row.add(i);
            map.put(arr[i], row);

        }



        return indices;

    }


    public static void main(String[] args) {

        int[] arr = {1, 3, 2, 2, 3, 4, 2, 4, 5};
        int target = 6;

        ArrayList<ArrayList<Integer>> ans = FindTheIndices(arr, target);

        System.out.println(ans);
    }
}