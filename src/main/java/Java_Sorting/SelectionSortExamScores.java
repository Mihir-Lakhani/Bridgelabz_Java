package Java_Sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class SelectionSortExamScores {

    static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){

            int min = i;
            int temp;

            for(int j=i+1; j < arr.length; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }

            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;


        }
    }

    public static void main(String[] args) {


        int[] Array = {9, 1, 2, 4, 3, 8, 3, 6};

        selectionSort(Array);
        System.out.println(Arrays.toString(Array));
    }
}