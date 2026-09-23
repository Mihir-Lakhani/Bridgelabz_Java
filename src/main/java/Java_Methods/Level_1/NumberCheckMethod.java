/*
5. A program to check whether a number is positive, negative or zero
using a method.
 */

package Java_Methods.Level_1;
import java.util.Scanner;

public class NumberCheckMethod {

    //Method to check whether number is positive, negative or zero
    public static int checkNumber(int number){

        if(number > 0){
            return 1;

        }else if(number < 0){
            return -1;

        }else{
            return 0;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking input

        //Call the method and store the returned value
        int result = checkNumber(number);

        //Print the result
        System.out.println(result);
    }
}