/*
10. Create a program to take a number as input and find
the frequency of each digit using arrays.
 */

package Java_Arrays.Level_2;

import java.util.Scanner;

public class FreqOfDigits {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        n = Math.abs(n); // converting the neg number to positive if user entered a neg value
        int temp = n;
        int[] digits = new int[String.valueOf(n).length()]; // creating an array of size of number of digits in the number
        int index = 0;
        while(temp!=0){
            digits[index] = temp%10;
            temp/=10;
            index++;
        }
        int[] freq = new int[10];
        for(int i:digits){
            freq[i-1]++;
        }

        System.out.println("Digit\tFrequency");
        for(int i=0; i<10; i++){
            System.out.printf("%d\t\t%d\n", i, freq[i]);
        }

    }
}
