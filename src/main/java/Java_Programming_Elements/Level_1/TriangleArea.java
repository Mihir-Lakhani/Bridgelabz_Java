/*
A program to find the area of a triangle
in square centimeters and square inches.
 */

package Java_Programming_Elements.Level_1;
import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the base in cm: ");
        double base = sc.nextDouble(); //Taking base input

        System.out.println("Enter the height in cm: ");
        double height = sc.nextDouble(); //Taking height input

        //Calculate area in square centimeters
        double areaCm = 0.5 * base * height;

        //Convert square centimeters to square inches
        double areaInches = areaCm / (2.54 * 2.54);

        //Print both areas
        System.out.printf("The area of the triangle is %.2f square centimeters and %.2f square inches",
                areaCm, areaInches);
    }
}