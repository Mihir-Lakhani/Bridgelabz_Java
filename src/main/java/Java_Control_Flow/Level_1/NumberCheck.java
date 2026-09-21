/*
A program to check whether a number is positive, negative or zero.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class NumberCheck {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking input for the number

        //Check if the number is positive
        if(number > 0){
            System.out.println("The number is positive");

            //Check if the number is negative
        }else if(number < 0){
            System.out.println("The number is negative");

            //Otherwise the number is zero
        }else{
            System.out.println("The number is zero");
        }
    }
}