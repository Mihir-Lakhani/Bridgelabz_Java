/*
8. Create a program to find the youngest friends among 3 Amar, Akbar and Anthony
based on their ages and tallest among the friends based on their heights and display it
 */


package Java_Methods.Level_2;

import java.util.Scanner;

public class YoungestAndTallest {
    public static String Youngest(int[] ages) { //Funtion to find the youngest
        int age = Math.min(ages[0], Math.min(ages[1], ages[2]));
        if (age == ages[0]) {
            return "Amar";
        } else if (age == ages[1]) {
            return "Akhbar";
        } else {
            return "Anthony";
        }
    }

    public static String Tallest(int[] heights) { //Function to find the Tallest
        int height = Math.min(heights[0], Math.min(heights[1], heights[2]));
        if (height == heights[0]) {
            return "Amar";
        } else if (height == heights[1]) {
            return "Akhbar";
        } else {
            return "Anthony";
        }
    }

    public static void main(String[] args) {
        int[] ages = new int[3];
        int[] heights = new int[3];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < ages.length; i++) { //looping through the arrays to put the values
            System.out.printf("Enter the Age of person %d: ", i + 1);
            ages[i] = sc.nextInt();
            System.out.printf("Enter the Height of person %d: ", i + 1);
            heights[i] = sc.nextInt();
        }

        System.out.printf("The Youngest of them is %s\nThe Tallest of them is %s", Youngest(ages), Tallest(heights)); //Calling both the methods with the array arguements


    }
}
