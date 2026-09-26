package Java_Methods.Level_3;

import java.util.Scanner;

public class CalenderDisplay {

    public static boolean isLeapYear(int year){
        if ((year%4==0 && year%100!=0) || (year%400 == 0)){
            return true;
        }
        return false;
    }

    public static int GetTheDays(int month, int year){
        int[]  DaysInMonth = {
                31, (isLeapYear(year)) ? 29 : 28, 31, 30,
                31, 30, 31, 31,
                30, 31, 30, 31
        };

        return DaysInMonth[month -1];
    }

    public static String GetTheName(int month){
        String[] months = {
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        };
        return months[month-1];
    }

    public static int FirstOfMonth(int m, int y){

        int d=1;
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + 31*m0 / 12) % 7;

        return d0;

    }

    public static void DisplayTheCalender(int d0, int month, int year){

        System.out.printf("%s\t%d\n", GetTheName(month), year);
        System.out.printf("Sun\tMon\tTue\tWed\tThu\tFri\tSat\n");
        for(int i=0; i<d0; i++){
            System.out.printf("   \t");
        }
        for (int i=1; i<=GetTheDays(month, year); i++){
            if ((d0 + i -1)%7==0){
                System.out.println();
            }
            System.out.printf("%4d",i);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the month: ");
        int m = sc.nextInt();
        System.out.println("Enter the year: ");
        int y = sc.nextInt();

        DisplayTheCalender(FirstOfMonth(m, y), m, y);




    }
}