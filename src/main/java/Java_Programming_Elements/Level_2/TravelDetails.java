/*
A program to take travel details as user input
and calculate the total distance and total time.
 */

package Java_Programming_Elements.Level_2;
import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter starting city: ");
        String fromCity = sc.nextLine();

        System.out.println("Enter via city: ");
        String viaCity = sc.nextLine();

        System.out.println("Enter final city: ");
        String toCity = sc.nextLine();

        System.out.println("Enter distance from starting city to via city in miles: ");
        double fromToVia = sc.nextDouble();

        System.out.println("Enter distance from via city to final city in miles: ");
        double viaToFinalCity = sc.nextDouble();

        System.out.println("Enter time from starting city to via city in hours: ");
        double timeFromToVia = sc.nextDouble();

        System.out.println("Enter time from via city to final city in hours: ");
        double timeViaToFinalCity = sc.nextDouble();

        //Calculate total distance and total time
        double totalDistance = fromToVia + viaToFinalCity;
        double totalTime = timeFromToVia + timeViaToFinalCity;

        //Print the travel details
        System.out.printf("%s travels from %s to %s via %s.\n",
                name, fromCity, toCity, viaCity);

        System.out.printf("The total distance is %.2f miles and total time taken is %.2f hours",
                totalDistance, totalTime);
    }
}