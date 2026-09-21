/*
A program to check whether the given month and day are in the Spring Season.
 */

package Java_Control_Flow.Level_1;

public class SpringSeason {
    public static void main(String[] args){

        //Take month and day from command line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        //Check if the date is between March 20 and June 20
        if((month == 3 && day >= 20) ||
                (month > 3 && month < 6) ||
                (month == 6 && day <= 20)){

            System.out.println("Its a Spring Season");

        }else{
            System.out.println("Not a Spring Season");
        }
    }
}