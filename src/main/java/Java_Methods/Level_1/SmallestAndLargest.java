/*
8. Write a program to find the smallest and largest of three numbers.
 */

package Java_Methods.Level_1;

import java.util.Scanner;

public class SmallestAndLargest {

    //Method to find smallest and largest of three numbers
    public static int[] findSmallestAndLargest(int number1, int number2, int number3){

        //Find the smallest number
        int smallest = Math.min(number1, Math.min(number2, number3));

        //Find the largest number
        int largest = Math.max(number1, Math.max(number2, number3));

        //Store both values in an array
        int[] result = {smallest, largest};

        return result;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.println("Enter second number: ");
        int number2 = sc.nextInt();

        System.out.println("Enter third number: ");
        int number3 = sc.nextInt();

        //Call the method and store the returned array
        int[] result = findSmallestAndLargest(number1, number2, number3);

        //Print smallest and largest numbers
        System.out.printf("The smallest number is %d and the largest number is %d",
                result[0], result[1]);
    }
}