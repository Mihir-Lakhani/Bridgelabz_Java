/*
2. A program to take user input for 5 numbers and check whether a number is positive,  negative, or zero.
Further for positive numbers check if the number is even or odd.
Finally compare the first and last elements of the array and display if they equal, greater or less
 */

package Java_Arrays.Level_1;

import java.util.Scanner;

public class PositiveEvenorOdd {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //initialize the Scanner as sc

        System.out.println("Enter the number of elements: ");
        int number = sc.nextInt(); //take  the number of elements in the array

        int arr[] = new int[number];

        for(int i=0; i<arr.length; i++){
            System.out.printf("Enter number %d: ", i+1);
            arr[i]=sc.nextInt(); //Input every number in the array
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) { //if the number is pos then check for even or odd
                if (arr[i] % 2 == 0) { // for even
                    System.out.println("Positive Even");
                } else { //rest odd
                    System.out.println("Positive Odd");
                }
            } else if (arr[i] == 0) {
                System.out.println("Zero");
            } else {
                System.out.println("Negative");
            }
        }
    }
}
