/*
4. Write a program to split the text into words and find the shortest and longest strings in a given text
    Hint =>
    Take user input using the Scanner nextLine() method
    Create a Method to split the text into words using the charAt() method without using the String built-in split() method and return the words.
    Create a method to find and return a string's length without using the length() method.
    Create a method to take the word array and return a 2D String array of the word and its corresponding length. Use String built-in function String.valueOf() to generate the String value for the number
    Create a Method that takes the 2D array of word and corresponding length as parameters, find the shortest and longest string and return them in an 1D int array.
    The main function calls the user-defined methods and displays the result.
 */

package Java_Strings.Level_2;

import java.util.Scanner;

public class ShortLongWord {
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
        int spaces = 0;
        for (int i = 0; i < getLen(s); i++) {
            if (s.charAt(i) == ' ') spaces++;
        }

        String[] words = new String[spaces + 1];
        int k = 0;
        String word = "";

        for (int i = 0; i < getLen(s); i++) {
            if (s.charAt(i) == ' ') {
                words[k++] = word;
                word = "";
            } else {
                word += s.charAt(i);
            }
        }
        words[k] = word;
        return words;
    }

    static String[][] makeTable(String[] words) {
        String[][] data = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            data[i][0] = words[i];
            data[i][1] = String.valueOf(getLen(words[i]));
        }
        return data;
    }

    static int[] findWords(String[][] data) {
        int small = 0;
        int large = 0;

        for (int i = 1; i < data.length; i++) {
            int n = Integer.parseInt(data[i][1]);
            if (n < Integer.parseInt(data[small][1])) small = i;
            if (n > Integer.parseInt(data[large][1])) large = i;
        }
        return new int[]{small, large};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] data = makeTable(mySplit(text));
        int[] ans = findWords(data);

        System.out.println("Shortest word: " + data[ans[0]][0]);
        System.out.println("Longest word: " + data[ans[1]][0]);
        sc.close();
    }
}