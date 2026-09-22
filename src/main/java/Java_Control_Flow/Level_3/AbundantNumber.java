/*
 A program to check if a number is Abundant Number or not
 */

package Java_Control_Flow.Level_3;

import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //Initialize the Scanner as sc

        System.out.println("Enter any number to check: ");
        int num = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        System.out.printf("Is the number %d Abundant Number? %s", num, (num < sum) ? "Yes" : "No");
    }
}
