/*
A program to check whether the entered year is a Leap Year or not.
 */

package Java_Control_Flow.Level_2;
import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the year: ");
        int year = sc.nextInt(); //Taking input for year

        //Check if the year belongs to Gregorian Calendar
        if(year >= 1582){

            //Check if year is divisible by 400
            if(year % 400 == 0){
                System.out.println("The Year is a Leap Year");

                //If divisible by 100 then it is not a leap year
            }else if(year % 100 == 0){
                System.out.println("The Year is not a Leap Year");

                //Check if year is divisible by 4
            }else if(year % 4 == 0){
                System.out.println("The Year is a Leap Year");

            }else{
                System.out.println("The Year is not a Leap Year");
            }

        }else{
            System.out.println("The year should be greater than or equal to 1582");
        }
    }
}