package Java_Programming_Elements.Level_2;

import java.util.Scanner;

/*
Scan or input two numbers and then find out and print their Quotient and Remainder
*/

public class QuotientAndRemainder {
    public static void main(String[] args) {

        //Initialize the Scanner as sc
        Scanner sc = new Scanner(System.in);

        //Input both the numbers on by one
        System.out.println("Enter number 1: ");
        int num1 = sc.nextInt();

        System.out.println("Enter number 2: ");
        int num2 = sc.nextInt();

        //Compute the Quotient and remainder in double variable
        double quotient = (double)num1/num2;

        double remainder = num1%num2;

        //Print both the computed values
        System.out.printf("The Quotient is %f and the Remainder is %f of two number %d and %d", quotient, remainder, num1, num2);


    }
}