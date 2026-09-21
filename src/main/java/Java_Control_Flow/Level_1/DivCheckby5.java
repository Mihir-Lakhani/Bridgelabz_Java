/*
A program to check if a number is divisible by 5
 */


package Java_Control_Flow.Level_1;
import java.util.Scanner;
public class DivCheckby5 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize the Scanner as sc

        System.out.println("Enter the number: ");
        int num = sc.nextInt(); //Taking input for the number

        System.out.printf("Is the number %d Divisible by 5? ", num);

        if(num%5==0){ //if the number is div by 5
            System.out.println("Yes");
        }else{ // if the number is not divisible by 5
            System.out.println("No");
        }

    }
}
