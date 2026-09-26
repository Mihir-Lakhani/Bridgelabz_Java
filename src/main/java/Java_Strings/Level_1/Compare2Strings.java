/*
1. Write a program to compare two strings using the charAt() method and check the result with the built-in String equals() method
    Hint =>
    Take user input using the  Scanner next() method for 2 String variables
    Write a method to compare two strings using the charAt() method and return a boolean result
    Use the String Built-In method to check if the results are the same and display the result
 */

package Java_Strings.Level_1;

import java.util.Scanner;

public class Compare2Strings {

    public static boolean compareWithCharAt(String str1, String str2){
        if (str1.length()!=str2.length()){
            return false;
        }
        for (int i = 0 ; i < str1.length(); i++){
            if (str1.charAt(i) != str2.charAt(i)){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter string 1: ");
        String str1 = sc.next();

        System.out.printf("Enter string 2: ");
        String str2 = sc.next();

        boolean charAtResult = compareWithCharAt(str1, str2);
        boolean equalsResult = str1.equals(str2);

        System.out.println("Result using charAt(): " + charAtResult);
        System.out.println("Result using equals(): " + equalsResult);


    }
}