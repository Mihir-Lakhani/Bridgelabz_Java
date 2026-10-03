/*
2. Reverse a String
Problem:
Write a Java program to reverse a given string without using any built-in reverse
functions.
 */

package ExtraPracticeProgram.JavaStringsPracticeProblems;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ReverseTeString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();
        StringBuilder rev = new StringBuilder();
        for (int i = str.length()-1; i>=0; i--){
            rev.append(str.charAt(i));
        }

        System.out.printf("The Original String: %s\n", str);
        System.out.printf("The Reversed String: %s\n", rev);
    }
}