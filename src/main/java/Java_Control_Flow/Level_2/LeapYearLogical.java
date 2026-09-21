/*
A program to check whether the entered year is a Leap Year
using logical AND and OR operators.
 */

package Java_Control_Flow.Level_2;
import java.util.Scanner;

public class LeapYearLogical {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the year: ");
        int year = sc.nextInt(); //Taking input for year

        //Check if the year belongs to Gregorian Calendar
        if(year < 1582){
            System.out.println("The year should be greater than or equal to 1582");

            //Check Leap Year using a single logical condition
        }else if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            System.out.println("The Year is a Leap Year");

        }else{
            System.out.println("The Year is not a Leap Year");
        }
    }
}