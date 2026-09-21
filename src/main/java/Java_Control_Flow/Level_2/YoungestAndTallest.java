/*
A program to find the youngest and tallest friend
among Amar, Akbar and Anthony.
 */

package Java_Control_Flow.Level_2;
import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        //Input Amar's age and height
        System.out.println("Enter Amar's age: ");
        int amar_age = sc.nextInt();

        System.out.println("Enter Amar's height: ");
        double amar_height = sc.nextDouble();

        //Input Akbar's age and height
        System.out.println("Enter Akbar's age: ");
        int akbar_age = sc.nextInt();

        System.out.println("Enter Akbar's height: ");
        double akbar_height = sc.nextDouble();

        //Input Anthony's age and height
        System.out.println("Enter Anthony's age: ");
        int anthony_age = sc.nextInt();

        System.out.println("Enter Anthony's height: ");
        double anthony_height = sc.nextDouble();

        //Find the smallest age
        int youngest_age = Math.min(amar_age, Math.min(akbar_age, anthony_age));

        //Find the largest height
        double tallest_height = Math.max(amar_height, Math.max(akbar_height, anthony_height));

        String youngest_friend;
        String tallest_friend;

        //Find the youngest friend
        if(youngest_age == amar_age){
            youngest_friend = "Amar";
        }else if(youngest_age == akbar_age){
            youngest_friend = "Akbar";
        }else{
            youngest_friend = "Anthony";
        }

        //Find the tallest friend
        if(tallest_height == amar_height){
            tallest_friend = "Amar";
        }else if(tallest_height == akbar_height){
            tallest_friend = "Akbar";
        }else{
            tallest_friend = "Anthony";
        }

        //Print the results
        System.out.println("The youngest friend is " + youngest_friend);
        System.out.println("The tallest friend is " + tallest_friend);
    }
}