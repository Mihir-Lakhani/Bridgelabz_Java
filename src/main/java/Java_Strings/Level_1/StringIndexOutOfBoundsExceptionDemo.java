/*
5. Write a program to demonstrate StringIndexOutOfBoundsException
    Hint =>
    Define a variable of type String and take user input to assign a value
    Write a Method to generate the Exception. Access the index using charAt() beyond the length of the String. This will generate a runtime exception and abruptly stop the program.
    Write the Method to demonstrate StringIndexOutOfBoundsException. Access the index using charAt() beyond the length of the String. Then write try catch block for Exception while accessing the String method
    From the main Firstly call the method to generate the Exception then call the method to handle the RuntimeException
 */

package Java_Strings.Level_1;

import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionDemo {

    public static void generateException(String text){
        char a = text.charAt(text.length());
    }


    public static void handleException(String text){
        try{
            char a = text.charAt(text.length());
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("StringIndexOutOfBoundsException => " + e.getMessage());
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        handleException(text);

    }
}