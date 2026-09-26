package Java_Methods.Level_3;

import Java_Arrays.Level_2.FindTheBMI;

import java.util.Arrays;
import java.util.Scanner;

public class ShortestTallestAndMeanHeight {
    public int FindTheSum(int[] arr){
        int sum = 0;
        for(int i:arr){
            sum+=i;

        }
        return sum;
    }
    public int FindTheMean(int[] arr, int sum){
        int mean = sum/ arr.length;
        return mean;
    }
    public int FindTheShortestHeight(int[] arr){
        int shortest = arr[0];
        for(int i:arr){
            shortest = Math.min(shortest, i);
        }
        return shortest;
    }
    public int FindTheTallestHeight(int[] arr){
        int tallest = arr[0];
        for(int i:arr){
            tallest = Math.max(tallest, i);
        }
        return tallest;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] heights = new int[11];

        for(int i = 0; i < 11; i++){
            heights[i] = 150 + (int)(Math.random() * 100);
        }
        ShortestTallestAndMeanHeight obj = new ShortestTallestAndMeanHeight();
        System.out.printf("The Sum of the array %s is %d\n", Arrays.toString(heights), obj.FindTheSum(heights));
        System.out.printf("The Mean of the array %s is %d\n", Arrays.toString(heights), obj.FindTheMean(heights, obj.FindTheSum(heights)));
        System.out.printf("The Shortest in the array %s is %d\n", Arrays.toString(heights), obj.FindTheShortestHeight(heights));
        System.out.printf("The Sume of the array %s is %d\n", Arrays.toString(heights), obj.FindTheTallestHeight(heights));


    }
}
