/*
A program to find the sum until the user enters 0 or a negative number.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class SumUntilNegative {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        double total = 0.0; //Variable to store total

        //Infinite loop
        while(true){

            System.out.println("Enter a number: ");
            double number = sc.nextDouble();

            //Stop the loop if number is 0 or negative
            if(number <= 0){
                break;
            }

            total = total + number; //Add number to total
        }

        System.out.printf("The total sum is %.2f", total);
    }
}