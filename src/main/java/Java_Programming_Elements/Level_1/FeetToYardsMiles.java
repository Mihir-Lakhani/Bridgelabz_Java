/*
A program to find the distance in yards and miles
for the distance provided by the user in feet.
 */

package Java_Programming_Elements.Level_1;
import java.util.Scanner;

public class FeetToYardsMiles {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter distance in feet: ");
        double distanceInFeet = sc.nextDouble(); //Taking distance input

        //Convert feet to yards
        double distanceInYards = distanceInFeet / 3.0;

        //Convert yards to miles
        double distanceInMiles = distanceInYards / 1760.0;

        //Print the converted distances
        System.out.printf("The distance %.2f feet is %.2f yards and %.2f miles",
                distanceInFeet, distanceInYards, distanceInMiles);
    }
}