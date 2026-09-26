package Java_Strings.Level_1;

import java.util.Scanner;

public class ToUpperCase {
    public static String convertToUppercase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            result += ch;
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String userDefinedResult = convertToUppercase(text);
        String builtInResult = text.toUpperCase();

        System.out.println("User-defined result: " + userDefinedResult);
        System.out.println("Built-in result: " + builtInResult);
        System.out.println("Both results are equal: " +
                compareStrings(userDefinedResult, builtInResult));
        sc.close();
    }
}