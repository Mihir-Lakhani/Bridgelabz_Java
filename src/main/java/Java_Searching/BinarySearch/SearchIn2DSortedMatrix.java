package Java_Searching.BinarySearch;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class SearchIn2DSortedMatrix {

    private static int FindInSorted2D(int[][] arr, int target){

        if (arr.length == 0){
            return -1;
        }

        int low = 0;
        int high = (arr.length)*(arr[0].length) -1;

        while(low<=high){
            int mid = low + (high - low) / 2;
            if (arr[getRow(arr, mid)][getCol(arr, mid)] == target) {
                return mid;
            }
            if (arr[getRow(arr, mid)][getCol(arr, mid)] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }

        }

        return -1;
    }

    private static int getRow(int[][] arr, int mid){
        return mid / arr[0].length;
    }
    private static int getCol(int[][] arr, int mid) {
        return mid % arr[0].length;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(FindInSorted2D(arr, 16) ); // true
        System.out.println(FindInSorted2D(arr, 13) ); // false
    }
}