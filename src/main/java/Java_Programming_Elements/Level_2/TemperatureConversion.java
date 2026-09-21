/*
Take input values considering them in Fahrenheit and convert it to Celsius and then print that value
 */

package Java_Programming_Elements.Level_2;
import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args){

        //Initialize the Scanner as sc
        Scanner sc = new Scanner(System.in);

        //Input the Fahrenheit value and store it in a variable named as F
        System.out.println("Enter the value in fahrenheit: ");
        int F = sc.nextInt();

        //Compute the Fahrenheit value in Celsius and store that in a variable named C
        double C = (F - 32) * 5.0/9.0;

        //Print the Computed Values
        System.out.printf("The %d Fahrenheit is %.2f Celsius", F, C);

    }
}
