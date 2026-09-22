/*
 A program to check if a number is Armstrong or not
 */

package Java_Control_Flow.Level_3;
import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize the Scanner as sc

        System.out.println("Enter any number to check: ");
        int ognum = sc.nextInt();
        int num =  ognum;
        int sum = 0;

        while(num!=0){
            int remainder = num%10;
            num /= 10;
            sum += (int) Math.pow(remainder, 3);
        }

        System.out.printf("Is the number %d Armstrong? %s", ognum, (ognum == sum)? "Yes":"No");
    }
}
