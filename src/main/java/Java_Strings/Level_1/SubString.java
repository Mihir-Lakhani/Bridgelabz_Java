/*
2. Write a program to create a substring from a String using the charAt() method. Also, use the String built-in method substring() to find the substring of the text. Finally Compare the the two strings and display the results
    Hint =>
    Take user input using the  Scanner next() method to take the String variable and also the start and the end index to get the substring from the given text
    Write a method to create a substring from a string using the charAt() method with the string, start, and end index as the parameters
    Write a method to compare two strings using the charAt() method and return a boolean result
    Use the String built-in method substring() to get the substring and compare the two strings. And finally display the result

 */

package Java_Strings.Level_1;

import java.util.Scanner;

public class SubString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String string = sc.next();
        System.out.println("Enter start index: ");
        int start = sc.nextInt();
        System.out.println("Enter end index: ");
        int end = sc.nextInt();

        System.out.printf("USING charAt() => The substring is \"%s\" of the given string \"%s\"\n", substringUsingCharAt(string, start, end), string);
        System.out.printf("USING substring() => The substring is \"%s\" of the given string \"%s\"\n", string.substring(start, end), string);

    }

    public static String substringUsingCharAt(String string, int start, int end){

        String result = "";

        for (int i=start; i<end; i++){
            result += string.charAt(i);
        }
        return result;
    }




}