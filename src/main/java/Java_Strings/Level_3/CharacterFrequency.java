/*
4. Write a program to find the frequency of characters in a string using
the charAt() method and display the result.

Hint =>
Create a method to find the frequency of characters using charAt() and
return the characters and their frequencies in a 2D array.
Create an array of size 256 to store the frequency of ASCII characters.
Loop through the text to find the frequency of every character.
Create an array to store the characters and frequencies.
Loop through the text and store every character and its frequency only once.
The main function takes user input, calls the method and displays the result.
*/

package Java_Strings.Level_3;

import java.util.Scanner;

public class CharacterFrequency {
    public static String[][] findFrequency(String text) {
        int[] freq = new int[256];
        boolean[] used = new boolean[256];
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!used[ch]) {
                used[ch] = true;
                count++;
            }
        }

        String[][] ans = new String[count][2];
        used = new boolean[256];
        int k = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (!used[ch]) {
                ans[k][0] = String.valueOf(ch);
                ans[k][1] = String.valueOf(freq[ch]);
                used[ch] = true;
                k++;
            }
        }
        return ans;
    }

    public static void display(String[][] data) {
        System.out.println("Character\tFrequency");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        display(findFrequency(text));
        sc.close();
    }
}