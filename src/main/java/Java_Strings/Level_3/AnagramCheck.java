/*
8. Write a program to check if two texts are anagrams and display the result.

Hint =>
An anagram is a word or phrase formed by rearranging the same letters to
form another word or phrase.
Write a method to check if two texts are anagrams.
Check whether the lengths of both texts are equal.
Create frequency arrays for both texts.
Find the frequency of characters in both texts using loops.
Compare the frequencies. If they are different, return false.
In main take user inputs, call the method and display the result.
*/

package Java_Strings.Level_3;

import java.util.Scanner;

public class AnagramCheck {
    public static boolean checkAnagram(String text1, String text2) {
        if (text1.length() != text2.length()) return false;

        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < text1.length(); i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String text1 = sc.nextLine();

        System.out.print("Enter second text: ");
        String text2 = sc.nextLine();

        if (checkAnagram(text1, text2)) {
            System.out.println("The texts are anagrams");
        } else {
            System.out.println("The texts are not anagrams");
        }
        sc.close();
    }
}