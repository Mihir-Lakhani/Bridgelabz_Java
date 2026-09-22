/*
A program to find the multiplication table of a number entered by the user from 6 to 9 and display the result
 */

package Java_Arrays.Level_1;
import java.util.Scanner;
public class MultiplicationTable6to9 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = sc.nextInt();

        int arr[] = new int[4];

        for(int i=0; i<4; i++){
            arr[i]=number * (i+6);
        }

        for (int i =0; i<arr.length; i++){
            System.out.printf("%d * %d = %d\n", number, i+6, arr[i]);
        }

    }
}
