/*
A program to calculate Simple Interest
using Principal, Rate and Time.
 */

package Java_Programming_Elements.Level_2;
import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter Principal: ");
        double principal = sc.nextDouble();

        System.out.println("Enter Rate of Interest: ");
        double rate = sc.nextDouble();

        System.out.println("Enter Time: ");
        double time = sc.nextDouble();

        //Calculate Simple Interest
        double simpleInterest = principal * rate * time / 100.0;

        //Print the result
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f and Time %.2f",
                simpleInterest, principal, rate, time);
    }
}