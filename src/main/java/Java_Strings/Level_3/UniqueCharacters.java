/*
2. Find unique characters in a string using the charAt() method and
display the result.

Hint =>
Create a method to find the length of the text without using length().
Create a method to find unique characters using charAt() and return them
as a 1D array.
Create an array having the same size as the text.
Use an outer loop for every character and an inner loop to compare it
with the previous characters.
If the character is unique, store it in the result array.
Create a new array containing only the unique characters.
The main function takes user input, calls the methods and displays the result.
*/

package Java_Strings.Level_3;

import java.util.Scanner;

public class UniqueCharacters {
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    public static char[] findUnique(String text) {
        int len = findLength(text);
        char[] temp = new char[len];
        int count = 0;

        for (int i = 0; i < len; i++) {
            boolean unique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    unique = false;
                    break;
                }
            }

            if (unique) {
                temp[count] = text.charAt(i);
                count++;
            }
        }

        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char[] result = findUnique(text);

        System.out.println("Unique characters:");
        for (char ch : result) {
            System.out.print(ch + " ");
        }
        sc.close();
    }
}