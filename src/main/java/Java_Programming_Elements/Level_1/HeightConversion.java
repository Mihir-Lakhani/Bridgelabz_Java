/*
A program to convert height in centimeters
to feet and inches.
 */

package Java_Programming_Elements.Level_1;
import java.util.Scanner;

public class HeightConversion {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter height in centimeters: ");
        double heightCm = sc.nextDouble(); //Taking height input

        //Convert centimeters to inches
        double inches = heightCm / 2.54;

        //Convert inches to feet
        double feet = inches / 12.0;

        //Print converted height
        System.out.printf("Your Height in cm is %.2f while in feet is %.2f and inches is %.2f",
                heightCm, feet, inches);
    }
}