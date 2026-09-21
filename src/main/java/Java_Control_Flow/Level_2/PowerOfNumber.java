/*
A program to find the power of a number.
 */

package Java_Control_Flow.Level_2;
import java.util.Scanner;

public class PowerOfNumber {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking number input

        System.out.println("Enter the power: ");
        int power = sc.nextInt(); //Taking power input

        long result = 1; //Initialize result as 1

        //Multiply the number power number of times
        for(int i = 1; i <= power; i++){

            result = result * number;
        }

        //Print the result
        System.out.printf("%d raised to the power %d is %d",
                number, power, result);
    }
}