/*
A program to find the multiplication table of a number from 6 to 9.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking input

        //Print multiplication table from 6 to 9
        for(int i = 6; i <= 9; i++){

            System.out.printf("%d * %d = %d\n", number, i, number * i);
        }
    }
}