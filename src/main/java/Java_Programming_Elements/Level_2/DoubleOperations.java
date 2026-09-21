/*
Taking three double inputs as a b and c and assigning operations and storing the values in variables
 */


package Java_Programming_Elements.Level_2;
import java.util.Scanner;

public class DoubleOperations {
    public static void main(String[] args){

        //Initialize Scanner as sc
        Scanner sc = new Scanner(System.in);

        //Take all the three integer inputs
        System.out.println("Eneter value of a: ");
        double a = sc.nextDouble();
        System.out.println("Eneter value of b: ");
        double b = sc.nextDouble();
        System.out.println("Eneter value of c: ");
        double c = sc.nextDouble();

        //Compute all the double operations
        double op1 = a + b * c;
        double op2 = a * b + c;
        double op3 = c + a / b;
        double op4 = a % b + c;

        //Print all the computed values in the terminal
        System.out.printf("The result of int operations are %f, %f, %f and %f", op1, op2, op3, op4);
    }
}
