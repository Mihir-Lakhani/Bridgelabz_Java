/*
A program to find the greatest factor of a number
besides the number itself.
 */

package Java_Control_Flow.Level_2;
import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking input for number

        int greatestFactor = 1; //Variable to store greatest factor

        //Start checking from one less than the number
        for(int i = number - 1; i >= 1; i--){

            //Check if i perfectly divides the number
            if(number % i == 0){

                greatestFactor = i;
                break;
            }
        }

        System.out.printf("The greatest factor of %d besides itself is %d",
                number, greatestFactor);
    }
}