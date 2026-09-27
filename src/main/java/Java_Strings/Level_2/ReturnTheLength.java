package Java_Strings.Level_2;

import java.util.Scanner;

public class ReturnTheLength {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String text = sc.next();

        int length = FindTheLength(text);
        int lengthUsingBuiltIn = text.length();

        System.out.printf("The length using the exception method: %s\n", length);
        System.out.printf("The length using the Built-In method: %s", lengthUsingBuiltIn);

    }

    public static int FindTheLength(String text){
        int index = 0;
        while(true){
            try{
                text.charAt(index);

                index++;

            }catch(StringIndexOutOfBoundsException e){
                System.out.printf("StringIndexOutOfBoundsException => %s\n", e.getMessage());
                break;
            }
        }
        return index;
    }
}