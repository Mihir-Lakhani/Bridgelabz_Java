/*
A program to find the sum of numbers until the user enters 0.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        double total = 0.0; //Variable to store total

        System.out.println("Enter a number: ");
        double number = sc.nextDouble(); //Take first input

        //Continue until the user enters 0
        while(number != 0){

            total = total + number; //Add number to total

            System.out.println("Enter a number: ");
            number = sc.nextDouble(); //Take input again
        }

        System.out.printf("The total sum is %.2f", total);
    }
}