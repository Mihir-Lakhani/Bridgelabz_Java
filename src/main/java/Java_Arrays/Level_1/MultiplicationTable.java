/*
3. A program to print a multiplication table of a number.
 */


package Java_Arrays.Level_1;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Inbitialize the Scanner as sc

        System.out.println("Enter the number: ");
        int num = sc.nextInt();

        int arr[] = new int[10];

        for (int i=1; i<=10; i++){
            arr[i-1] = num*i;
        }

        for (int i =0; i<arr.length; i++){
            System.out.printf("%d * %d = %d\n", num, i+1, arr[i]);
        }
    }
}
