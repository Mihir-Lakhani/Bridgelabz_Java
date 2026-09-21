/*
A program to check whether a person can vote based on their age.
 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the age: ");
        int age = sc.nextInt(); //Taking input for age

        //Check if the person is eligible to vote
        if(age >= 18){
            System.out.printf("The person's age is %d and can vote.", age);
        }else{
            System.out.printf("The person's age is %d and cannot vote.", age);
        }
    }
}