/*
9. Write a program to take user input for 5 numbers and check whether
each number is positive or negative. For positive numbers check
whether the number is even or odd. Finally compare the first and
last elements of the array.
 */

package Java_Methods.Level_2;

import java.util.Scanner;

public class NumberCheckMethod {

    //Method to check whether a number is positive
    public static boolean isPositive(int number) {

        return number > 0;
    }

    //Method to check whether a number is even
    public static boolean isEven(int number) {

        return number % 2 == 0;
    }

    //Method to compare two numbers
    public static int compare(int number1, int number2) {

        if (number1 > number2) {
            return 1;

        } else if (number1 == number2) {
            return 0;

        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[5];

        //Take input for 5 numbers
        for (int i = 0; i < numbers.length; i++) {

            System.out.printf("Enter number %d: ", i + 1);
            numbers[i] = sc.nextInt();
        }


        for (int i = 0; i < numbers.length; i++) { //Check each number

            if (isPositive(numbers[i])) {

                if (isEven(numbers[i])) {
                    System.out.printf("%d is Positive and Even%n", numbers[i]);

                } else {
                    System.out.printf("%d is Positive and Odd%n", numbers[i]);
                }

            } else if (numbers[i] < 0) {

                System.out.printf("%d is Negative%n", numbers[i]);

            } else {

                System.out.println("0 is Zero");
            }
        }


        int result = compare(numbers[0], numbers[numbers.length - 1]);  //Compare first and last element

        if (result == 1) {

            System.out.println("The first element is greater than the last element");

        } else if (result == 0) {

            System.out.println("The first and last elements are equal");

        } else {

            System.out.println("The first element is less than the last element");
        }
    }
}