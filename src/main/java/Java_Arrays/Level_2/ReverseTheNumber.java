/*
5. Create a program to take a number as input and reverse the number.
To do this, store the digits of the number in an array and display the array in reverse order
 */

package Java_Arrays.Level_2;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseTheNumber {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = sc.nextInt();

        int count = String.valueOf(n).length();
        int digits[] = new int[count];
        int index = 0;
        while(n!=0){
            digits[index] = n%10;
            n/=10;
            index++;
        }

        int[] reverse = new int[count];
        for(int i=count-1; i>=0; i--){
            reverse[count-1-i] = digits[i];
        }

        System.out.printf("The original number is %s\nThe reverse number is %s", String.join("",Arrays.toString(digits)), String.join("",Arrays.toString(reverse)));
    }

}
