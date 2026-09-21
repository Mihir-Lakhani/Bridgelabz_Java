/*
A program to check whether the entered number is a Prime Number or not.
 */

package Java_Control_Flow.Level_2;
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number: ");
        int number = sc.nextInt(); //Taking input for number

        boolean isPrime = true; //Variable to store whether number is prime

        //Prime numbers should be greater than 1
        if(number <= 1){
            isPrime = false;

        }else{

            //Check divisibility from 2 till number - 1
            for(int i = 2; i < number; i++){

                if(number % i == 0){
                    isPrime = false;
                    break;
                }
            }
        }

        //Print the result
        if(isPrime){
            System.out.printf("%d is a Prime Number", number);
        }else{
            System.out.printf("%d is not a Prime Number", number);
        }
    }
}