/*
A program to check if the first, second, or third number is the largest of the three.

 */

package Java_Control_Flow.Level_1;
import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number 1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter number 2: ");
        int num2 = sc.nextInt();
        System.out.println("Enter number 3: ");
        int num3 = sc.nextInt();

        if(num1>num2 && num1>num3){
            System.out.println("Is the first number the largest? Yes\n" +
                    "Is the second number the largest? No\n" +
                    "Is the third number the largest? No\n");
        }else if(num2>num3 && num2>num1){
            System.out.println("Is the first number the largest? No\n" +
                    "Is the second number the largest? Yes\n" +
                    "Is the third number the largest? No\n");
        }else{
            System.out.println("Is the first number the largest? No\n" +
                    "Is the second number the largest? No\n" +
                    "Is the third number the largest? Yes\n");
        }
    }
}
