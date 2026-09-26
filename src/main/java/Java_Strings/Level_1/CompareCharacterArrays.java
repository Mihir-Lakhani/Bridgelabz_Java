/*
3. Write a program to return all the characters in a string using the user-defined method,  compare the result with the String built-in toCharArray() method, and display the result
    Hint =>
    Take user input using the  Scanner next() method to take the text into a String variable
    Write a method to return the characters in a string without using the toCharArray()
    Write a method to compare two string arrays and return a boolean result
    In the main() call the user-defined method and the String built-in ​​toCharArray() method, compare the 2 arrays, and finally display the result

 */

package Java_Strings.Level_1;
import java.util.Scanner;

public class CompareCharacterArrays {
    public static char[] getCharacters(String text) {
        char[] characters = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            characters[i] = text.charAt(i);
        }
        return characters;
    }

    public static boolean compareArrays(char[] array1, char[] array2) {
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) return false;
        }
        return true;
    }

    public static void displayArray(char[] characters) {
        for (char character : characters) {
            System.out.print(character + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] userDefinedArray = getCharacters(text);
        char[] builtInArray = text.toCharArray();

        System.out.print("User-defined array: ");
        displayArray(userDefinedArray);
        System.out.print("Built-in array: ");
        displayArray(builtInArray);

        System.out.println("Both arrays are equal: " +
                compareArrays(userDefinedArray, builtInArray));
        sc.close();
    }
}