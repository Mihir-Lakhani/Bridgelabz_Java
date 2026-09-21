/*
 A program to find the total income of a person by taking salary and bonus from user

 */

package Java_Programming_Elements.Level_2;
import java.util.Scanner;

public class SalaryAndBonus {
    public static void main(String[] args){

        //Initialize a Scanner as sc
        Scanner sc = new Scanner(System.in);

        //Take the user input for salary and the bonus and store them in int variables with appropriate names
        System.out.println("Enter your Salary: ");
        int salary = sc.nextInt();

        System.out.println("Enter your Bonus: ");
        int bonus = sc.nextInt();

        //Add the Salary and the bonus to find out the final income and store then in a int variable
        int income = salary + bonus;

        //Print the final income value
        System.out.printf("The salary is INR %d and the bonus is INR %d, hence the total income is INR %d", salary, bonus, income);
    }
}
