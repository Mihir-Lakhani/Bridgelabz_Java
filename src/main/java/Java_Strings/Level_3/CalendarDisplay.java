/*
9. Create a program to display a calendar for a given month and year.
The program should take the month and year as input and display the calendar
for that month. For example, for 07 2005, display the calendar for July 2005.

Hint =>
Write a method to get the name of the month using an array.
Write a method to get the number of days in a month using a days array.
For February, check whether the year is a leap year.
Write a leap-year method.
Write a method to get the first day using the Gregorian calendar algorithm:

y0 = y - (14 - m) / 12
x = y0 + y0 / 4 - y0 / 100 + y0 / 400
m0 = m + 12 * ((14 - m) / 12) - 2
d0 = (d + x + 31 * m0 / 12) mod 7

Use one loop for spaces before the first day.
Use another loop to display the days.
Use %3d for proper spacing and move to the next line after Saturday.
*/

package Java_Strings.Level_3;

import java.util.Scanner;

public class CalendarDisplay {
    public static String getMonthName(int month) {
        String[] names = {
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        };
        return names[month - 1];
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0)
                || (year % 4 == 0 && year % 100 != 0);
    }

    public static int getDays(int month, int year) {
        int[] days = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        if (month == 2 && isLeapYear(year)) return 29;
        return days[month - 1];
    }

    public static int getFirstDay(int month, int year) {
        int day = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;

        return (day + x + 31 * m0 / 12) % 7;
    }

    public static void displayCalendar(int month, int year) {
        int totalDays = getDays(month, year);
        int firstDay = getFirstDay(month, year);

        System.out.println("\n        " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= totalDays; day++) {
            System.out.printf("%3d ", day);

            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month: ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Invalid month");
        } else {
            displayCalendar(month, year);
        }
        sc.close();
    }
}