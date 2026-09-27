/*
3. Write a program to find the first non-repeating character in a string
and show the result.

Hint =>
A non-repeating character occurs only once in the string.
Create a method to find the first non-repeating character using charAt().
Create an array of size 256 to store the frequency of ASCII characters.
Loop through the text and store the frequency of each character.
Loop through the text again and find the first character whose frequency is 1.
In the main function take user input, call the method and display the result.
*/

package Java_Strings.Level_3;

import java.util.Scanner;

public class FirstNonRepeating {
    public static char findCharacter(String text) {
        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char result = findCharacter(text);

        if (result == '\0') {
            System.out.println("No non-repeating character found");
        } else {
            System.out.println("First non-repeating character: " + result);
        }
        sc.close();
    }
}