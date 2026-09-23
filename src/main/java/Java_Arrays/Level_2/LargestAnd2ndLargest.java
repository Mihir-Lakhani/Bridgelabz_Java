/*
3. Create a program to store the digits of the number in an array and find the largest and second largest element of the array.
 */

package Java_Arrays.Level_2;

import java.util.Scanner;

public class LargestAnd2ndLargest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        int maxDigit = 10;

        //Array to store digits
        int[] arr = new int[maxDigit];

        //Index of the array
        int index = 0;

        //Store digits of the number in the array
        while(n != 0){

            int temp = n % 10;
            n /= 10;

            arr[index] = temp;

            index++;

            //Stop if maximum digits are stored
            if(index == maxDigit){
                break;
            }
        }

        int l = 0;
        int s = 0;

        for (int i : arr) {
            if (i > l) {
                s=l;
                l = i;
            }else{

            }
            if (i > s && i < l) {
                s=i;
            }
        }


        System.out.printf("Largest: %d\nSecond Largest: %d", l, s);
    }
}
