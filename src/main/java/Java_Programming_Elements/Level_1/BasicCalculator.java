/*
A program to perform addition, subtraction,
multiplication and division of two numbers.
 */

package Java_Programming_Elements.Level_1;
import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter first number: ");
        double number1 = sc.nextDouble(); //Taking first number

        System.out.println("Enter second number: ");
        double number2 = sc.nextDouble(); //Taking second number

        //Perform all arithmetic operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;

        //Print all the calculated values
        System.out.printf("The addition, subtraction, multiplication and division value of 2 numbers %.2f and %.2f is %.2f, %.2f, %.2f, and %.2f",
                number1, number2, addition, subtraction, multiplication, division);
    }
}