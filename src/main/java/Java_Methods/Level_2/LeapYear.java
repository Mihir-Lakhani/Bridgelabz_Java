/*
3. Write a program that takes a year as input and outputs the Year is a Leap Year or not
 */

package Java_Methods.Level_2;

import java.util.Scanner;

public class LeapYear {
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) { //Leap Year Condition
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //Initialize a Scanner as sc

        int year;
        while (true) {
            System.out.println("Enter the Year after 1581: ");
            year = sc.nextInt();
            if (year >= 1582) { //cap of the year
                break;
            }
        }
        System.out.printf("The year %d is %s a Leap Year", year, (isLeapYear(year)) ? "indeed" : "not"); //print the statement depending on the condition

    }
}
