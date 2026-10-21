package Java_ExceptionHandling;

import java.util.*;


public class DivideUserInput {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter First Number: ");
            int a = sc.nextInt();
            System.out.println("Enter Second Number: ");
            int b = sc.nextInt();
            try{
                int c = a/b;
                System.out.println("the answer is: " + c);
            }catch(ArithmeticException e){
                System.out.println("Arithmatic Exception : " + e.getMessage());
            }
        }catch (InputMismatchException e){
            System.out.println("InputMismatchException : " + "Please enter a valid whole number");
        }

    }
}