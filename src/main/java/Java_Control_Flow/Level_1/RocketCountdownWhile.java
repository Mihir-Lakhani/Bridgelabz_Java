/*
A program to count down from the user entered number to 1 using while loop.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class RocketCountdownWhile {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the countdown number: ");
        int counter = sc.nextInt(); //Taking input for countdown

        //Continue the loop until counter becomes 0
        while(counter >= 1){

            System.out.println(counter);

            counter--; //Decrease counter by 1
        }

        System.out.println("Launch!");
    }
}