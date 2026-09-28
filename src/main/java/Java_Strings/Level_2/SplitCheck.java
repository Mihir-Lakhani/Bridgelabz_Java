/*
2. Write a program to split the text into words, compare the result with the split() method and display the result
    Hint =>
    Take user input using the Scanner nextLine() method
    Create a Method to find the length of the String without using the built-in length() method.
    Create a Method to split the text into words using the charAt() method without using the String built-in split() method and return the words. Use the following logic
    Firstly Count the number of words in the text and create an array to store the indexes of the spaces for each word in a 1D array
    Then Create an array to store the words and use the indexes to extract the words
    Create a method to compare the two String arrays and return a boolean
    The main function calls the user-defined method and the built-in split() method. Call the user defined method to compare the two string arrays and display the result
 */

package Java_Strings.Level_2;

import java.util.Scanner;

public class SplitCheck {
    static int getLen(String s) {
        int n = 0;
        try {
            while (true) {
                s.charAt(n);
                n++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return n;
    }

    static String[] mySplit(String s) {
        int n = getLen(s);
        int spaces = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') spaces++;
        }

        int[] pos = new int[spaces + 2];
        pos[0] = -1;
        int k = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') pos[k++] = i;
        }
        pos[k] = n;

        String[] words = new String[spaces + 1];
        for (int i = 0; i < words.length; i++) {
            String word = "";
            for (int j = pos[i] + 1; j < pos[i + 1]; j++) {
                word += s.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }

    static boolean same(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] a = mySplit(text);
        String[] b = text.split(" ");

        for (String word : a) System.out.println(word);
        System.out.println("Both results are same: " + same(a, b));
        sc.close();
    }
}