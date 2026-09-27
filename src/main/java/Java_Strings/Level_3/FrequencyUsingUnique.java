/*
5. Write a program to find the frequency of characters in a string using
unique characters and display the result.

Hint =>
Create a method to find unique characters using charAt() and nested loops
and return them as a 1D array.
Create a method to find the frequency of characters.
Create an array of size 256 and use ASCII values as indexes.
Loop through the text and store the frequency of every character.
Call the uniqueCharacters() method.
Create a 2D String array to store unique characters and their frequencies.
Loop through the unique characters and store every character and its frequency.
The main function takes user input, calls the methods and displays the result.
*/

package Java_Strings.Level_3;

import java.util.Scanner;

public class FrequencyUsingUnique {
    public static char[] uniqueCharacters(String text) {
        char[] temp = new char[text.length()];
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            boolean found = false;

            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                temp[count] = text.charAt(i);
                count++;
            }
        }

        char[] ans = new char[count];
        for (int i = 0; i < count; i++) {
            ans[i] = temp[i];
        }
        return ans;
    }

    public static String[][] findFrequency(String text) {
        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] unique = uniqueCharacters(text);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] result = findFrequency(text);

        System.out.println("Character\tFrequency");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t\t" + result[i][1]);
        }
        sc.close();
    }
}