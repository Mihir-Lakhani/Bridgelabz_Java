/*
2. Sum of n Natural Numbers using Recursion
 */

package Java_Methods.Level_2;

import java.util.Scanner;

public class NaturalNoSumUsingRecursion {

    public static int recursiveSum(int n) { //initialized a function for recursion

        if (n == 1) {
            return 1;
        }
        return n + recursiveSum(n - 1); // calling the function inside itself making it recursion
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2; //formula for the sum
    }

    public static void main(String[] args) { //Our main function

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number n: "); //Taking the input number
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("Not a natural number");
            System.exit(0);
        }

        int RecursionSum = recursiveSum(n);
        int FormulaSum = formulaSum(n);

        if (RecursionSum == FormulaSum) { // if the condition is true the print the values
            System.out.printf("The value from recursion is %d and from formula is %d.", RecursionSum, FormulaSum);
        }
    }
}
