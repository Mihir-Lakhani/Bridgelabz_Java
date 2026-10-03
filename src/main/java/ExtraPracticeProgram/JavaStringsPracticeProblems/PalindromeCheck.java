/*
2. Reverse a String
Problem:
Write a Java program to reverse a given string without using any built-in reverse
functions.
 */

package ExtraPracticeProgram.JavaStringsPracticeProblems;

import java.util.Scanner;



public class PalindromeCheck {
    public static void main(String[] args) {


        Boolean isPalindrome=true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();
        StringBuilder rev = new StringBuilder();
        for (int i = str.length()-1; i>=0; i--){
            if (str.charAt(i) != str.charAt(str.length()-i-1)){
                isPalindrome=false;
            }
        }

        System.out.printf("The String: %s is %s a Palindrome", str, (isPalindrome) ? "Indeed" : "Not");
    }
}