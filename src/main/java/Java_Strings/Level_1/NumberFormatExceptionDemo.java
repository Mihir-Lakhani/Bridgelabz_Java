package Java_Strings.Level_1;

import java.util.Scanner;

public class NumberFormatExceptionDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input: ");
        String text = sc.next();

        //generateException(text);

        handleException(text);


    }

    public static void generateException(String text){

        int n = Integer.parseInt(text);

    }

    public static void handleException(String text){

        try{
            int n = Integer.parseInt(text);
        }catch(NumberFormatException e){
            System.out.println("NumberFormatException => " + e.getMessage());
        }

    }
}