/*
A program to convert a 2D Array to 1D Array
 */

package Java_Arrays.Level_1;
import java.util.Arrays;
import java.util.Scanner;
public class TwoDtoOneDArray {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Write the no. of Rows: ");
        int row = sc.nextInt();

        System.out.println("Write the no. of Columns: ");
        int col = sc.nextInt();

        int arr2[][] = new int[row][col];

        for(int i=0; i < row; i++){
            for(int j=0; j<col; j++){
                System.out.printf("Enter the value for arr2[%d][%d]: ", i, j);
                arr2[i][j] = sc.nextInt();
            }
        }
        int index = 0;
        int arr1[] = new int[row*col];
        for(int i=0; i < row; i++){
            for(int j=0; j<col; j++){
                arr1[index]=arr2[i][j];
                index++;
            }
        }
        System.out.printf("The arr1: %s", Arrays.toString(arr1));

    }
}
