package Java_Strings.Level_1;

import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text: ");
        String text = sc.next();

        handleException(text);
    }

    public static void generateException(String text){
        String newText = text.substring(4   ,3);
    }

    public static void handleException(String text){
        try{
            String newText = text.substring(2,1);
        }catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException => " + e.getMessage());
        }
    }
}