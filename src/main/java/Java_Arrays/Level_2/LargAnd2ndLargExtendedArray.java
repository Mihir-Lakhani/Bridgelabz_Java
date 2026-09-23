/*
4. Create a program to store the digits of the number in an array
and find the largest and second largest element of the array.
But Array is not limited to fixed maxDigit, array should be resized
 */

package Java_Arrays.Level_2;

import java.util.Arrays;
import java.util.Scanner;

public class LargAnd2ndLargExtendedArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        long n = sc.nextLong();

        int maxDigit = 10;

        //Array to store digits
        int[] arr = new int[maxDigit];

        //Index of the array
        int index = 0;

        //Store digits of the number in the array
        while(n != 0){

            int temp = (int)(n % 10);
            n /= 10;

            //Increase array size if required
            if(index == maxDigit){
                maxDigit++;
                arr = Arrays.copyOf(arr, maxDigit);
            }

            arr[index] = temp;
            index++;
        }

        int l = 0;
        int s = 0;

        //Find largest and second largest
        for(int i = 0; i < index; i++){

            if(arr[i] > l){
                s = l;
                l = arr[i];

            }else if(arr[i] > s && arr[i] < l){
                s = arr[i];
            }
        }

        System.out.printf("Largest: %d%nSecond Largest: %d", l, s);
    }
}