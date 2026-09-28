/*
5. Write a program to find vowels and consonants in a string and display the count of  Vowels and Consonants in the string
    Hint =>
    Create a method to check if the character is a vowel or consonant and return the result. The logic used here is as follows:
    Convert the character to lowercase if it is an uppercase letter using the ASCII values of the characters
    Check if the character is a vowel or consonant and return Vowel, Consonant, or Not a Letter
    Create a Method to Method to find vowels and consonants in a string using charAt() method and finally return the count of vowels and consonants in an array
    Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
 */

package Java_Strings.Level_2;

import java.util.Scanner;

public class VowelCount {
    static String check(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32);

        if (ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u') {
            return "Vowel";
        }

        if (ch >= 'a' && ch <= 'z') return "Consonant";
        return "Not a Letter";
    }

    static int[] count(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            String type = check(text.charAt(i));
            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        int[] result = count(text);
        System.out.println("Vowels: " + result[0]);
        System.out.println("Consonants: " + result[1]);
        sc.close();
    }
}