/*
A program to find the side of a square
using the perimeter entered by the user.
 */

package Java_Programming_Elements.Level_1;
import java.util.Scanner;

public class SideOfSquare {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the perimeter of the square: ");
        double perimeter = sc.nextDouble(); //Taking perimeter input

        //Calculate the side of the square
        double side = perimeter / 4.0;

        //Print the side and perimeter
        System.out.printf("The length of the side is %.2f whose perimeter is %.2f",
                side, perimeter);
    }
}