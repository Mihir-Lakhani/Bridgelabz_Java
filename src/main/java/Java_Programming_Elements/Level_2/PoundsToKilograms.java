/*
A program to convert weight in pounds to kilograms.
 */

package Java_Programming_Elements.Level_2;
import java.util.Scanner;

public class PoundsToKilograms {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter weight in pounds: ");
        double weight = sc.nextDouble(); //Taking weight input

        //Convert pounds to kilograms
        double weightInKg = weight / 2.2;

        //Print the converted weight
        System.out.printf("The weight of the person in pound is %.2f and in kg is %.2f",
                weight, weightInKg);
    }
}