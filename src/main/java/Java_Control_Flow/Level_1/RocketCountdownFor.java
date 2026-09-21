/*
A program to count down from the user entered number to 1 using for loop.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class RocketCountdownFor {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the countdown number: ");
        int counter = sc.nextInt(); //Taking input for countdown

        //Count down from counter to 1
        for(int i = counter; i >= 1; i--){
            System.out.println(i);
        }

        System.out.println("Launch!");
    }
}