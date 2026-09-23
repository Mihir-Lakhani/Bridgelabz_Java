/*
1. A program to input principal, Rate and Time values to calculate Simple Interest
 */

package Java_Methods.Level_1;
import java.util.Scanner;
public class SimpleInterest {

    public static double CalcSI(double principal, int rate, int time){
        double Interest = (principal * rate * time ) / 100;//calc the interest

        return Interest; //Returning the interest value to save it somewhere in the main code or to print it
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the principal: ");
        double principal = sc.nextDouble();

        System.out.println("Enter the rate: ");
        int rate = sc.nextInt();

        System.out.println("Enter the time in years: ");
        int time = sc.nextInt();
        // calling the method to calculate the simple interest with the parameters taken in input
        System.out.printf("The Simple Interest is %.2f for Principal %.2f, rate %d and time %d years", CalcSI(principal, rate, time), principal, rate, time);
    }
}
