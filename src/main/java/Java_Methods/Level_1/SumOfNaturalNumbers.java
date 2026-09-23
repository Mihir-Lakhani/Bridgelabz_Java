/*
7. Write a program to find the sum of n natural numbers using loop.
 */

package Java_Methods.Level_1;

import java.util.Scanner;

public class SumOfNaturalNumbers {

    //Method to find the sum of n natural numbers
    public static int findSum(int number){

        int sum = 0;

        for(int i = 1; i <= number; i++){
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking number input

        //Check if number is a natural number
        if(number > 0){

            int sum = findSum(number); //Call method

            System.out.printf("The sum of %d natural numbers is %d", number, sum);

        }else{
            System.out.println("The number is not a natural number");
        }
    }
}