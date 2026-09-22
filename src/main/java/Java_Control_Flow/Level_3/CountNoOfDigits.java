/*
A Program to count the number of digits in an integer
 */

package Java_Control_Flow.Level_3;
import java.util.Scanner;

public class CountNoOfDigits {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the Number: ");
        int num = sc.nextInt();
        int save = num;
        int count = 0;

        while(num != 0){
            num/=10;
            count++;
        }

        System.out.printf("The number of digits in %d are %d", save, count);
    }
}
