/*
3.     Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
    Hint =>
    Method to find the count of digits in the number and a Method to Store the digits of the number in a digits array
    Method to find the sum of the digits of a number using the digits array
    Method to find the sum of the squares of the digits of a number using the digits array. Use Math.pow() method
    Method to Check if a number is a harshad number using a digits array. A number is called a Harshad number if it is divisible by the sum of its digits. For e.g. 21
    Method to find the frequency of each digit in the number. Create a 2D array to store the frequency with digit in the first column and frequency in the second column.
4.     Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
    Hint =>
    Method to find the count of digits in the number and a Method to Store the digits of the number in a digits array
    Method to reverse the digits array
    Method to compare two arrays and check if they are equal
    Method to check if a number is a palindrome using the Digits. A palindrome number is a number that remains the same when its digits are reversed.
    Method to Check if a number is a duck number using the digits array. A duck number is a number that has a non-zero digit present in it
5.     Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
    Hint =>
    Method to Check if a number is prime number. A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.
    Method to Check if a number is a neon number. A neon number is a number where the sum of digits of the square of the number is equal to the number itself
    Method to Check if a number is a spy number. A number is called a spy number if the sum of its digits is equal to the product of its digits
    Method to Check if a number is an automorphic number. An automorphic number is a number whose square ends with the number itself. E.g. 5 is an automorphic number
    Method to Check if a number is a buzz number. A buzz number is a number that is either divisible by 7 or ends with 7
6.     Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
    Hint =>
    Method to find factors of a number and return them as an array. Note there are 2 for loops one for the count and another for finding the factor and storing in the array
    Method to find the greates factor of a Number using the factors array
    Method to find the sum of the factors using factors array and return the sum
    Method to find the product of the factors using factors array and return the product
    Method to find product of cube of the factors using the factors array. Use Math.pow()
    Method to Check if a number is a perfect number. Perfect numbers are positive integers that are equal to the sum of their proper divisors
    Method to find the number is a abundant number. A number is called an abundant number if the sum of its proper divisors is greater than the number itself
    Method to find the number is a deficient number. A number is called a deficient number if the sum of its proper divisors is less than the number itself
    Method to Check if a number is a strong number. A number is called a strong number if the sum of the factorial of its digits is equal to the number itself

 */

package Java_Methods.Level_3;

import java.util.Arrays;
import java.util.Scanner;

public class HarshadDuckPalindromeNumberChecker {

    //3. Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
    //Hint =>
    //Method to find the count of digits in the number and a Method to Store the digits of the number in a digits array
    //Method to find the sum of the digits of a number using the digits array
    //Method to find the sum of the squares of the digits of a number using the digits array. Use Math.pow() method
    //Method to Check if a number is a harshad number using a digits array. A number is called a Harshad number if it is divisible by the sum of its digits. For e.g. 21
    //Method to find the frequency of each digit in the number. Create a 2D array to store the frequency with digit in the first column and frequency in the second column.

    public static int FindTheCount(int n){
        int count = String.valueOf(n).length();
        return count;
    }

    public static int[] StoreTheDigits(int n){
        int[] digits = new int[FindTheCount(n)];

        for(int i=digits.length-1; i>=0; i--){
            digits[i]=n%10;
            n/=10;
        }
        return digits;
    }

    public static int FindSum(int[] digits){
        int sum = 0;
        for (int i: digits){
            sum+=i;
        }
        return sum;
    }

    public static int FindSumOfSq(int[] digits){
        int sum=0;
        for(int i: digits){
            sum+=(int)Math.pow(i,2);
        }
        return sum;
    }

    public static boolean isHarshad(int n){
        return n%FindSum(StoreTheDigits(n)) == 0;
    }

    public static int[][] FindTheFreq(int[] digits){

        int[][] frequency = new int[10][2];

        for(int i:digits){
            frequency[i][1]++;
        }
        for(int i = 0; i < 10; i++){
            frequency[i][0] = i;
        }

        return frequency;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        int count = FindTheCount(n);
        int[] digits = StoreTheDigits(n);
        int[][] frequency = FindTheFreq(digits);

        //3. Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
        //Hint =>
        //Method to find the count of digits in the number and a Method to Store the digits of the number in a digits array
        //Method to find the sum of the digits of a number using the digits array
        //Method to find the sum of the squares of the digits of a number using the digits array. Use Math.pow() method
        //Method to Check if a number is a harshad number using a digits array. A number is called a Harshad number if it is divisible by the sum of its digits. For e.g. 21
        //Method to find the frequency of each digit in the number. Create a 2D array to store the frequency with digit in the first column and frequency in the second column.

        System.out.printf("The Count of the digits is: %d\n", count);
        System.out.printf("The Storage Array of the number: %s\n", Arrays.toString(digits));
        System.out.printf("The Sum and the Sum of Squares of the number are %d and %d\n", FindSum(digits), FindSumOfSq(digits));
        System.out.printf("The number is %s a Harshad Number\n", (isHarshad(n))? "Indeed" : "Not");
        System.out.println("Digit\tFrequency");

        for(int i = 0; i < frequency.length; i++){

            if(frequency[i][1] > 0){

                System.out.printf(
                        "%d\t\t%d\n",
                        frequency[i][0],
                        frequency[i][1]
                );
            }
        }

        // 4. Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
        //Hint =>
        //Method to find the count of digits in the number and a Method to Store the digits of the number in a digits array
        //Method to reverse the digits array
        //Method to compare two arrays and check if they are equal
        //Method to check if a number is a palindrome using the Digits. A palindrome number is a number that remains the same when its digits are reversed.
        //Method to Check if a number is a duck number using the digits array. A duck number is a number that has a non-zero digit present in it
        System.out.println("==================================================================================================================");
        System.out.printf("The Digits are %s\n", Arrays.toString(digits));
        System.out.printf("The Reversed array is %s\n", Arrays.toString(ReverseArray(digits)));
        System.out.printf("The number is %s a Palindrome\n", (isPalindrome(digits))? "Indeed" : "Not");
        System.out.printf("The number is %s a Duck\n", (isDuck(digits))? "Indeed" : "Not");

        //5. Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
        //Hint =>
        //Method to Check if a number is prime number. A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.
        //Method to Check if a number is a neon number. A neon number is a number where the sum of digits of the square of the number is equal to the number itself
        //Method to Check if a number is a spy number. A number is called a spy number if the sum of its digits is equal to the product of its digits
        //Method to Check if a number is an automorphic number. An automorphic number is a number whose square ends with the number itself. E.g. 5 is an automorphic number
        //Method to Check if a number is a buzz number. A buzz number is a number that is either divisible by 7 or ends with 7
        System.out.println("==================================================================================================================");
        System.out.printf("The number %d is %s a Prime Number\n", n, (isPrime(n)) ? "Indeed" : "Not");
        System.out.printf("The number %d is %s a Neon Number\n", n, (isNeon(n)) ? "Indeed" : "Not");
        System.out.printf("The number %d is %s a Spy Number\n", n, (isSpy(n)) ? "Indeed" : "Not");
        System.out.printf("The number %d is %s a Automorphic Number\n", n, (isAutoMorphic(n)) ? "Indeed" : "Not");
        System.out.printf("The number %d is %s a Buzz Number\n", n, (isBuzz(n)) ? "Indeed" : "Not");

        //6. Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
        //Hint =>
        //Method to find factors of a number and return them as an array. Note there are 2 for loops one for the count and another for finding the factor and storing in the array
        //Method to find the greates factor of a Number using the factors array
        //Method to find the sum of the factors using factors array and return the sum
        //Method to find the product of the factors using factors array and return the product
        //Method to find product of cube of the factors using the factors array. Use Math.pow()
        //Method to Check if a number is a perfect number. Perfect numbers are positive integers that are equal to the sum of their proper divisors
        //Method to find the number is a abundant number. A number is called an abundant number if the sum of its proper divisors is greater than the number itself
        //Method to find the number is a deficient number. A number is called a deficient number if the sum of its proper divisors is less than the number itself
        //Method to Check if a number is a strong number. A number is called a strong number if the sum of the factorial of its digits is equal to the number itself

        System.out.println("==================================================================================================================");
        int[] factors = FindFactors(n);
        System.out.printf("The Factors of the number are %s\n", Arrays.toString(factors));
        System.out.printf("The Greatest Factor of the number is %d\n", FindGreatestFactor(factors));
        System.out.printf("The Sum of the Factors is %d\n", FindSumOfFactors(factors));
        System.out.printf("The Product of the Factors is %d\n", FindProdOfFactors(factors));
        System.out.printf("The Product of Cube of Factors is %d\n", FindProdOfCube(factors));
        System.out.printf("The number %d is %s a Perfect Number\n", n, (isPerfect(n)) ? "Indeed" : "Not");
        System.out.printf("The number %d is %s an Abundant Number\n", n, (isAbundant(n)) ? "Indeed" : "Not");
        System.out.printf("The number %d is %s a Deficient Number\n", n, (isDeficient(n)) ? "Indeed" : "Not");
        System.out.printf("The number %d is %s a Strong Number\n", n, (isStrong(n)) ? "Indeed" : "Not");

    }
    // 4. Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
    //Hint =>
    //Method to find the count of digits in the number and a Method to Store the digits of the number in a digits array
    //Method to reverse the digits array
    //Method to compare two arrays and check if they are equal
    //Method to check if a number is a palindrome using the Digits. A palindrome number is a number that remains the same when its digits are reversed.
    //Method to Check if a number is a duck number using the digits array. A duck number is a number that has a non-zero digit present in it


    public static int[] ReverseArray(int[] digits){
        int[] reversed = new int[digits.length];
        for(int i=digits.length-1; i>=0; i--){
            reversed[digits.length-i-1] = digits[i];
        }
        return reversed;
    }

    public static boolean isPalindrome(int[] digits){

        int[] reversed = ReverseArray(digits);
        return compareArrays(digits, reversed);
    }

    public static boolean compareArrays(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }

        for(int i=0; i<arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean isDuck(int[] digits){
        for(int i: digits){
            if (i==0){
                return true;
            }
        }
        return false;
    }

    //5. Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
    //Hint =>
    //Method to Check if a number is prime number. A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.
    //Method to Check if a number is a neon number. A neon number is a number where the sum of digits of the square of the number is equal to the number itself
    //Method to Check if a number is a spy number. A number is called a spy number if the sum of its digits is equal to the product of its digits
    //Method to Check if a number is an automorphic number. An automorphic number is a number whose square ends with the number itself. E.g. 5 is an automorphic number
    //Method to Check if a number is a buzz number. A buzz number is a number that is either divisible by 7 or ends with 7


    public static boolean isPrime(int n){
        for (int i = 1; i<n; i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    public static boolean isNeon(int n){
        int sq = (int)Math.pow(n,2);

        int[] arrayOfn = StoreTheDigits(n);
        int[] arrayOfsq= StoreTheDigits(sq);

        int sumOfn = FindSum(arrayOfn);
        int sumOfsq = FindSum(arrayOfsq);

        return sumOfn==sumOfsq;
    }

    public static boolean isSpy(int n){
        int[] arrayOfn = StoreTheDigits(n);
        int sumOfAll = FindSum(arrayOfn);
        int prodOfAll = FindProd(arrayOfn);

        return sumOfAll==prodOfAll;
    }

    public static boolean isAutoMorphic(int n){
        int sq = (int)Math.pow(n, 2);

        int[] arrayOfn= StoreTheDigits(n);
        int[] arrayOfSq= StoreTheDigits(sq);

        for (int i = 0; i<arrayOfn.length; i++){
            if (arrayOfSq[arrayOfSq.length - i -1] != arrayOfn[arrayOfn.length -i -1]){
                return false;
            }
        }
        return true;
    }

    public static boolean isBuzz(int n){
        int[] arrayOfn = StoreTheDigits(n);
        if (arrayOfn[arrayOfn.length-1] == 7 || n%7 == 0){
            return true;
        }
        return false;
    }

    public static int FindProd(int[] digits){
        int prod = 1;
        for (int i: digits){
            prod*=i;
        }
        return prod;
    }

    //6. Extend or Create a NumberChecker utility class and perform following task. Call from main() method the different methods and display results. Make sure all are static methods
    //Hint =>
    //Method to find factors of a number and return them as an array. Note there are 2 for loops one for the count and another for finding the factor and storing in the array
    //Method to find the greates factor of a Number using the factors array
    //Method to find the sum of the factors using factors array and return the sum
    //Method to find the product of the factors using factors array and return the product
    //Method to find product of cube of the factors using the factors array. Use Math.pow()
    //Method to Check if a number is a perfect number. Perfect numbers are positive integers that are equal to the sum of their proper divisors
    //Method to find the number is a abundant number. A number is called an abundant number if the sum of its proper divisors is greater than the number itself
    //Method to find the number is a deficient number. A number is called a deficient number if the sum of its proper divisors is less than the number itself
    //Method to Check if a number is a strong number. A number is called a strong number if the sum of the factorial of its digits is equal to the number itself

    public static int[] FindFactors(int n){

        int count = 0;

        for(int i=1; i<=n; i++){
            if(n%i==0){
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        for(int i=1; i<=n; i++){
            if(n%i==0){
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }


    public static int FindGreatestFactor(int[] factors){

        int greatest = Integer.MIN_VALUE;

        for(int i: factors){
            if(i>greatest){
                greatest = i;
            }
        }

        return greatest;
    }


    public static int FindSumOfFactors(int[] factors){

        int sum = 0;

        for(int i: factors){
            sum+=i;
        }

        return sum;
    }


    public static int FindProdOfFactors(int[] factors){

        int prod = 1;

        for(int i: factors){
            prod*=i;
        }

        return prod;
    }


    public static int FindProdOfCube(int[] factors){

        int prod = 1;

        for(int i: factors){
            prod*=(int)Math.pow(i,3);
        }

        return prod;
    }


    public static boolean isPerfect(int n){

        int[] factors = FindFactors(n);
        int sum = 0;

        for(int i=0; i<factors.length-1; i++){
            sum+=factors[i];
        }

        return sum==n;
    }


    public static boolean isAbundant(int n){

        int[] factors = FindFactors(n);
        int sum = 0;

        for(int i=0; i<factors.length-1; i++){
            sum+=factors[i];
        }

        return sum>n;
    }


    public static boolean isDeficient(int n){

        int[] factors = FindFactors(n);
        int sum = 0;

        for(int i=0; i<factors.length-1; i++){
            sum+=factors[i];
        }

        return sum<n;
    }


    public static boolean isStrong(int n){

        int[] digits = StoreTheDigits(n);
        int sum = 0;

        for(int i: digits){

            int factorial = 1;

            for(int j=1; j<=i; j++){
                factorial*=j;
            }

            sum+=factorial;
        }

        return sum==n;
    }

}