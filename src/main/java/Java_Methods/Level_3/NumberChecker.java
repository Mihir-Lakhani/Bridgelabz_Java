/*
2. Extend or Create a NumberChecker utility class and perform following task.
Call from main() method the different methods and display results.
Make sure all are static methods

Method to Find the count of digits in the number
Method to Store the digits of the number in a digits array
Method to Check if a number is a duck number using the digits array
Method to check if the number is an Armstrong number using the digits array
Method to find the largest and second largest elements in the digits array
Method to find the smallest and second smallest elements in the digits array
 */

package Java_Methods.Level_3;

import java.util.Arrays;
import java.util.Scanner;

public class NumberChecker {

    //Method to count the number of digits
    public static int CountTheDigits(int n){

        n = Math.abs(n);

        //0 itself has one digit
        if(n == 0){
            return 1;
        }
        int count = 0;

        while(n != 0){
            count++;
            n /= 10;
        }
        return count;
    }

    //Method to store the digits of the number in an array
    public static int[] StoreTheDigits(int n){

        n = Math.abs(n);

        int count = CountTheDigits(n);
        int[] digits = new int[count];
        //Special case for
        if(n == 0){
            digits[0] = 0;
            return digits;
        }
        int index = 0;

        while(n != 0){

            digits[index] = n % 10;
            n /= 10;

            index++;
        }

        return digits;
    }
    //Method to check whether the number is a Duck Number
    public static boolean isDuck(int[] digits){

        //Check whether any digit is 0
        for(int i : digits){

            if(i == 0){
                return true;
            }
        }

        return false;
    }

    //Method to check whether the number is an Armstrong Number
    public static boolean isArmstrong(int n, int[] digits, int count){

        if(n < 0){
            return false;
        }

        int sum = 0;

        for(int i : digits){

            sum += (int)Math.pow(i, count);
        }

        return sum == n;
    }

    //Method to find Largest and Second Largest digit
    public static int[] FindLargestAnd2ndLargest(int[] digits){

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i : digits){

            if(i > largest){

                second = largest;
                largest = i;
            }else if(i > second && i < largest){

                second = i;
            }
        }
        int[] largestAnswer = {largest, second};

        return largestAnswer;
    }


    //Method to find Smallest and Second-Smallest digit
    public static int[] FindSmallestAnd2ndSmallest(int[] digits){

        int smallest = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i : digits){

            if(i < smallest){

                second = smallest;
                smallest = i;

            }else if(i < second && i > smallest){

                second = i;
            }
        }

        int[] smallestAnswer = {smallest, second};

        return smallestAnswer;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = sc.nextInt();

        int count = CountTheDigits(n);

        int[] digits = StoreTheDigits(n);

        boolean duck = isDuck(digits);

        boolean armstrong = isArmstrong(n, digits, count);

        int[] largest = FindLargestAnd2ndLargest(digits);

        int[] smallest = FindSmallestAnd2ndSmallest(digits);


        System.out.println("Number of Digits: " + count);

        System.out.println("Digits Array: " + Arrays.toString(digits));

        System.out.println("Is Duck Number? " + duck);

        System.out.println("Is Armstrong Number? " + armstrong);

        System.out.println("Largest Digit: " + largest[0]);


        System.out.println("Second Largest Digit: " + largest[1]);


        System.out.println("Smallest Digit: " + smallest[0]);


        System.out.println("Second Smallest Digit: " + smallest[1]);


        sc.close();
    }
}