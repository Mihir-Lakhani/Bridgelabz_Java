package Java_Strings.Level_1;

import java.util.Scanner;

public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] names = new String[3];
        for(int i=0; i<3; i++){
            System.out.println("Enter the name: " + i);
            names[0] = sc.next();
        }

        //generateException(text);

        handleException(names);


    }

    public static void generateException(String[] names){

        System.out.println(names[names.length]);
    }

    public static void handleException(String[] names){

        try{
            System.out.println(names[names.length]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException => " + e.getMessage());
        }

    }
}