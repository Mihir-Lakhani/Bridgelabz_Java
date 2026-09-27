/*
7. Write a program to check if a text is palindrome and display the result.

Hint =>
A palindrome reads the same forward and backward.

Logic 1:
Write a method that compares characters from the start and end.
Set the start and end indexes.
If the characters are different, return false.

Logic 2:
Write a recursive method.
If the start index is greater than or equal to the end index, return true.
If the start and end characters are different, return false.
Otherwise call the method again with start + 1 and end - 1.

Logic 3:
Write a method to reverse a string using charAt() and return a character array.
Create the original array using toCharArray().
Compare the original and reversed arrays.

In main, perform the palindrome check using all three logics and display results.
*/

package Java_Strings.Level_3;

import java.util.Scanner;

public class PalindromeCheck {
    public static boolean checkUsingLoop(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean checkUsingRecursion(String text, int start, int end) {
        if (start >= end) return true;

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return checkUsingRecursion(text, start + 1, end - 1);
    }

    public static char[] reverse(String text) {
        char[] result = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(text.length() - 1 - i);
        }
        return result;
    }

    public static boolean checkUsingArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverse(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Using loop: " + checkUsingLoop(text));
        System.out.println("Using recursion: "
                + checkUsingRecursion(text, 0, text.length() - 1));
        System.out.println("Using arrays: " + checkUsingArray(text));
        sc.close();
    }
}