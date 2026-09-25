/*
Create a program to find the factors of a number taken as user input,
store the factors in an array and display the factors.
Also find the sum, sum of square of factors and product of the factors and display the results
 */


package Java_Methods.Level_2;

import java.util.Arrays;
import java.util.Scanner;

public class FactorsOfnumber {

    static int sum = 0;
    static int SumOfSq = 0;
    static int product = 1;

    static int[] FindTheFactors(int number) {


        System.out.println("Enter the number: ");
        int[] factors = new int[0];
        int count = 0;
        for (int i = 1; i < number; i++) {

            if (number % i == 0) {
                count++;
                factors = Arrays.copyOf(factors, count);
                factors[count - 1] = i;
                sum += i;
                SumOfSq += (int) Math.pow(i, 2);
                product *= i;
            }


        }
        return factors;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] factors = FindTheFactors(number);
        String factorsInString = Arrays.toString(factors);
        System.out.printf("The Factors of the number %d are %s\n" +
                "The Sume of the Factors %s is %d\n" +
                "The Sum of Square of the factors %s is %d\n" +
                "The Product of the Factors %s is %d", number, factorsInString, factorsInString, sum, factorsInString, SumOfSq, factorsInString, product);
    }
}
