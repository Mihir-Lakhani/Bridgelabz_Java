/*
 A program to find all the multiple of a number taken as user input below 100.
 */

package Java_Control_Flow.Level_2;
import java.util.Scanner;
public class MultipleTillHundred {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize the Scanner as sc

        System.out.println("Enter the number: ");
        int num = sc.nextInt();

        for(int i=100; i>0; i--){
            if(num%i==0){
                System.out.printf("%d%s",i, (i==1)? "": ",");
            }
        }
    }
}
