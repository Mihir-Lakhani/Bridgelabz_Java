/*
A program to print FizzBuzz from 0 to the user entered number using while loop.
 */

package Java_Control_Flow.Level_2;
import java.util.Scanner;

public class FizzBuzzWhile {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking input for number

        //Check if the entered number is positive
        if(number > 0){

            int counter = 0;

            //Loop from 0 to the entered number
            while(counter <= number){

                if(counter % 3 == 0 && counter % 5 == 0){
                    System.out.println("FizzBuzz");

                }else if(counter % 3 == 0){
                    System.out.println("Fizz");

                }else if(counter % 5 == 0){
                    System.out.println("Buzz");

                }else{
                    System.out.println(counter);
                }

                counter++; //Increase counter
            }

        }else{
            System.out.println("The number is not a positive integer");
        }
    }
}