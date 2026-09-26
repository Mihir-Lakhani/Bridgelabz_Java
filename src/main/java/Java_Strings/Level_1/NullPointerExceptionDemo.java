/*
4. Write a program to demonstrate NullPointerException.
    Hint =>
    Write a Method to generate the Exception. Here define the variable text and initialize it to null. Then call one of the String Method to generate the exception
    Write the Method to demonstrate NullPointerException. Here define the variable text and initialize it to null. Then write try catch block for handling the Exception while accessing one of the String method
    From the main Firstly call the method to generate the Exception then refactor the code to call the method to handle the RuntimeException
 */

package Java_Strings.Level_1;

import java.util.Scanner;

public class NullPointerExceptionDemo {

    public static void generateException(){
        String text = null;
        System.out.println(text.length());
    }

    public static void handleException(){
        String text = null;
        try{
            System.out.println(text.length());
        }catch(NullPointerException e){
            System.out.println("NullPointerException => "+ e.getMessage());
        }
    }

    public static void main(String[] args) {

        handleException();
        //generateException();
    }
}