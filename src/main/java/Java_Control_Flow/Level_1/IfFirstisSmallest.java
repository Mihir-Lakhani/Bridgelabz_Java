/*
A program to check if the first is the smallest of the 3 numbers.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;
public class IfFirstisSmallest {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter first number: ");
        int num1 = sc.nextInt(); //Input first number

        System.out.println("Enter second number: ");
        int num2 = sc.nextInt(); //Input second number

        System.out.println("Enter third number: ");
        int num3 = sc.nextInt(); //Input third number

        int minnum = Math.min(num1, Math.min(num2, num3)); //Store the smallest number

        //Check if the smallest num stored is equal to first number if yes then print Yes
        System.out.println("Is the first number the smallest? " + ((num1 == minnum)? "Yes": "No"));
    }
}
