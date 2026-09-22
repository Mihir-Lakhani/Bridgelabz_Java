/*
4. A program to store multiple values in an array up to a maximum of 10 or until the user enters a 0 or a negative number.
 */

package Java_Arrays.Level_1;
import java.util.Scanner;
import java.util.Arrays;

public class StopAtZeroorNeg {
    public static void main(String[] args){

        double arr[] = new double[10];
        double sum = 0;

        Scanner sc = new Scanner(System.in);
        int end =0;
        for(int i=0; i<10; i++){
            System.out.printf("Enter at index %d: ", i);
            int temp = sc.nextInt();
            if(temp == 0 || temp < 0){
                end = i;
                break;
            }
            arr[i] = temp;
            sum+=temp;

        }


        System.out.printf("%s and sum is: %.2f", Arrays.toString(Arrays.copyOfRange(arr, 0, end)), sum);
        //copyOfRange Slices the array and gives the new array and toString converts the array into sting making it easier to print
    }
}
