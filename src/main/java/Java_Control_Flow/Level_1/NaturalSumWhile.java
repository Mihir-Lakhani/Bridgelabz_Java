/*
A program to find the sum of n natural numbers using while loop
and compare it with the formula.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class NaturalSumWhile {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking input

        //Check if the number is a natural number
        if(number > 0){

            int formula_sum = number * (number + 1) / 2; //Sum using formula

            int loop_sum = 0;
            int counter = 1;

            //Calculate sum using while loop
            while(counter <= number){

                loop_sum = loop_sum + counter;

                counter++;
            }

            System.out.println("Sum using formula = " + formula_sum);
            System.out.println("Sum using while loop = " + loop_sum);

            //Compare both results
            if(formula_sum == loop_sum){
                System.out.println("Both computations are correct");
            }else{
                System.out.println("Both computations are not equal");
            }

        }else{
            System.out.println("The number is not a natural number");
        }
    }
}