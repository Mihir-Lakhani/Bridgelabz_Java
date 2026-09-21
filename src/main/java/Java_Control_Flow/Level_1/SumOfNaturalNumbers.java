/*
A program to check for a natural number and find the sum of n natural numbers.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking input for the number

        //Check if the number is a natural number
        if(number > 0){

            //Calculate the sum using the formula
            int sum = number * (number + 1) / 2;

            System.out.printf("The sum of %d natural numbers is %d", number, sum);

        }else{
            System.out.printf("The number %d is not a natural number", number);
        }
    }
}