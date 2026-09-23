/*
9. Write a program to take two numbers and print
their quotient and remainder.
 */

package Java_Methods.Level_1;

import java.util.Scanner;

public class RemainderAndQuotient {

    //Method to find remainder and quotient
    public static int[] findRemainderAndQuotient(int number, int divisor){

        //Calculate the remainder
        int remainder = number % divisor;

        //Calculate the quotient
        int quotient = number / divisor;

        //Store remainder and quotient in an array
        int[] result = {remainder, quotient};

        return result;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt();

        System.out.println("Enter the divisor: ");
        int divisor = sc.nextInt();

        //Call the method and store the returned array
        int[] result = findRemainderAndQuotient(number, divisor);

        //Print Quotient and Remainder
        System.out.printf("The Quotient is %d and Remainder is %d of two numbers %d and %d",
                result[1], result[0], number, divisor);
    }
}