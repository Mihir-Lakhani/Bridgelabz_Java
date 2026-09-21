/*
A program to print FizzBuzz from 0 to the user entered number using for loop.
 */

package Java_Control_Flow.Level_2;
import java.util.Scanner;

public class FizzBuzzFor {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking input for number

        //Check if the entered number is positive
        if(number > 0){

            //Loop from 0 to the entered number
            for(int i = 0; i <= number; i++){

                //Check multiples of both 3 and 5 first
                if(i % 3 == 0 && i % 5 == 0){
                    System.out.println("FizzBuzz");

                }else if(i % 3 == 0){
                    System.out.println("Fizz");

                }else if(i % 5 == 0){
                    System.out.println("Buzz");

                }else{
                    System.out.println(i);
                }
            }

        }else{
            System.out.println("The number is not a positive integer");
        }
    }
}