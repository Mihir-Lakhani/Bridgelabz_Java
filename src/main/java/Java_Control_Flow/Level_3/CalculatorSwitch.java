/*
A program to create a basic calculator
using switch case.
 */

package Java_Control_Flow.Level_3;
import java.util.Scanner;

public class CalculatorSwitch {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the first number: ");
        double first = sc.nextDouble(); //Taking first number

        System.out.println("Enter the second number: ");
        double second = sc.nextDouble(); //Taking second number

        System.out.println("Enter the operator (+, -, *, /): ");
        String op = sc.next(); //Taking operator input

        //Perform operation based on operator
        switch(op){

            case "+":
                System.out.printf("The result is %.2f", first + second);
                break;

            case "-":
                System.out.printf("The result is %.2f", first - second);
                break;

            case "*":
                System.out.printf("The result is %.2f", first * second);
                break;

            case "/":
                System.out.printf("The result is %.2f", first / second);
                break;

            default:
                System.out.println("Invalid Operator");
        }
    }
}