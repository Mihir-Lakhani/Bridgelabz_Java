/*
A program to find how many rounds an athlete must run
around a triangular park to complete 5 km.
 */

package Java_Programming_Elements.Level_2;
import java.util.Scanner;

public class AthleteRounds {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter side 1 in meters: ");
        double side1 = sc.nextDouble();

        System.out.println("Enter side 2 in meters: ");
        double side2 = sc.nextDouble();

        System.out.println("Enter side 3 in meters: ");
        double side3 = sc.nextDouble();

        //Calculate perimeter of the triangular park
        double perimeter = side1 + side2 + side3;

        //Distance to be covered is 5 km or 5000 meters
        double distance = 5000;

        //Calculate number of rounds
        double rounds = distance / perimeter;

        //Print the number of rounds
        System.out.printf("The total number of rounds the athlete will run is %.2f to complete 5 km",
                rounds);
    }
}