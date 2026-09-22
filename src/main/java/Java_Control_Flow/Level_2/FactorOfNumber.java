/*
 A program to find the factors of a number taken as user input.
 */

package Java_Control_Flow.Level_2;
import java.util.Scanner;

public class FactorOfNumber {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize the Scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //store the user input in int variable named number

        System.out.println("The factors of the given number are: ");
        int count = 0;
        for(int i=1; i<number; i++){ //going through all the numbers from 1 to the number
            if(number%i==0) { //check if those number can divide the input number
                System.out.printf("The %d factor is: %d\n", count + 1, i); //print the factor if yes
                count++; //increase the count with each factor to have the total count of factors
            }
        }
        if(count==0){
            System.out.println("None");
        }
    }
}
