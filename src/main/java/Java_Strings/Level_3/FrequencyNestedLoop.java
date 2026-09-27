/*
6. Write a program to find the frequency of characters in a string using
nested loops and display the result.

Hint =>
Create a method to find character frequencies and return the characters
and frequencies in a 1D array.
Create an array to store the frequency of each character and use
toCharArray() to create a character array.
Use an outer loop to iterate through the characters and initialize frequency
to 1. Use an inner loop to find duplicate characters.
For a duplicate, increase its frequency and mark the duplicate so it is
not counted again.
Create a 1D String array to store the characters and frequencies.
The main function takes user input, calls the method and displays the result.
*/

package Java_Strings.Level_3;

import java.util.Scanner;

public class FrequencyNestedLoop {
    public static String[] findFrequency(String text) {
        char[] ch = text.toCharArray();
        int[] freq = new int[ch.length];
        int count = 0;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '\0') continue;

            freq[i] = 1;

            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    freq[i]++;
                    ch[j] = '\0';
                }
            }
            count++;
        }

        String[] result = new String[count];
        int k = 0;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '\0') {
                result[k] = ch[i] + " - " + freq[i];
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] result = findFrequency(text);

        System.out.println("Character frequencies:");
        for (String value : result) {
            System.out.println(value);
        }
        sc.close();
    }
}