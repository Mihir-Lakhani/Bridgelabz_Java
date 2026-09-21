/*
 A program to input two numbers and swap them
 */

package Java_Programming_Elements.Level_2;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Swap2Num {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        //Input number 1
        System.out.println("Enter the value of num1: ");
        int num1 = sc.nextInt();

        System.out.println("Enter the value of num2: ");
        int num2 = sc.nextInt();

        System.out.printf("The value of num1 is %d and value of num2 is %d. \n", num1, num2);

        //temporary variable
        int temp = num1;
        num1 = num2;
        num2 = temp;

        //Print the new swapped values
        System.out.printf("The swapped value of num1 is %d and the value of num2 is %d.", num1, num2);
    }
}
