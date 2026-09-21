/*
A program to find the factorial of a positive integer using for loop.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class FactorialFor {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking input

        //Check if the number is positive
        if(number > 0){

            long factorial = 1;

            //Calculate factorial using for loop
            for(int i = 1; i <= number; i++){

                factorial = factorial * i;
            }

            System.out.printf("The factorial of %d is %d", number, factorial);

        }else{
            System.out.println("Please enter a positive integer");
        }
    }
}