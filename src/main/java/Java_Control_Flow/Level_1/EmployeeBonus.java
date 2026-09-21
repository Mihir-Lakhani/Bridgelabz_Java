/*
A program to find the bonus of an employee based on years of service.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the salary: ");
        double salary = sc.nextDouble(); //Taking salary input

        System.out.println("Enter the years of service: ");
        int years_of_service = sc.nextInt(); //Taking years of service

        double bonus = 0.0; //Variable to store bonus

        //Check if years of service is more than 5
        if(years_of_service > 5){

            bonus = salary * 5 / 100.0; //Calculate 5 percent bonus
        }

        System.out.printf("The bonus amount is INR %.2f", bonus);
    }
}