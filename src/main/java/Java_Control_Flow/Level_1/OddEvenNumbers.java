/*
A program to print whether each number from 1 to the user entered number
is odd or even.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking input

        //Check if the number is a natural number
        if(number > 0){

            //Loop from 1 to the entered number
            for(int i = 1; i <= number; i++){

                //Check if the number is even
                if(i % 2 == 0){
                    System.out.printf("%d is Even\n", i);

                }else{
                    System.out.printf("%d is Odd\n", i);
                }
            }

        }else{
            System.out.println("The number is not a natural number");
        }
    }
}