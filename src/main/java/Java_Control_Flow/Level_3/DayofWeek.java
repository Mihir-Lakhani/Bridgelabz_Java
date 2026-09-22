/*
A program to find the day of the week for a given date
using the Gregorian Calendar formula.
 */

package Java_Control_Flow.Level_3;

public class DayofWeek {
    public static void main(String[] args){

        //Take month, day and year from command-line arguments
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        //Calculate y0
        int y0 = y - (14 - m) / 12;

        //Calculate x
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;

        //Calculate m0
        int m0 = m + 12 * ((14 - m) / 12) - 2;

        //Calculate day of week
        int d0 = (d + x + 31 * m0 / 12) % 7;

        //Print the result
        System.out.println("The day of the week is " + d0);
    }
}