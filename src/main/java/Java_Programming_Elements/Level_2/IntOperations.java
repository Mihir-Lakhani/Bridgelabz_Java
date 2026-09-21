/*
Taking three int inputs as a b and c and assigning operations and storing the values in variables
 */


package Java_Programming_Elements.Level_2;
import java.util.Scanner;


public class IntOperations {
    public static void main(String[] args){

        //Initialize Scanner as sc
        Scanner sc = new Scanner(System.in);

        //Take all the three integer inputs
        System.out.println("Eneter value of a: ");
        int a = sc.nextInt();
        System.out.println("Eneter value of b: ");
        int b = sc.nextInt();
        System.out.println("Eneter value of c: ");
        int c = sc.nextInt();

        //Compute all the int operations
        int op1 = a + b * c;
        int op2 = a * b + c;
        int op3 = c + a / b;
        int op4 = a % b + c;

        //Print all the computed values in the terminal
        System.out.printf("The result of int operations are %d, %d, %d and %d", op1, op2, op3, op4);

    }

}
