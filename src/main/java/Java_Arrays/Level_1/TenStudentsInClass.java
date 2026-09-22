/*
1. A program to take user input for the age of all 10 students in a class and
check whether the student can vote depending on his/her age is greater or equal to 18.
 */

package Java_Arrays.Level_1;

import java.util.Scanner;

public class TenStudentsInClass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //Initialize the Scanner
        System.out.printf("Enter the number of students: ");
        int number = sc.nextInt(); //take the input for number of students

        int age[] = new int[number]; //initialize the array

        for (int i = 0; i < age.length; i++) {
            System.out.printf("Enter the age of Student %d: ", i + 1);
            age[i] = sc.nextInt(); //input the elements in array one by one
            if (age[i] < 0) {
                System.out.println("Age Can not be negative"); //Statement before exiting
                System.exit(0); //exit command for negative age
            }
        }
        /*
        for(int index=0; index<age.length; index++){
            System.out.printf("The Student with age %d can %s vote", age[index], (age[index]>18) ? "" : "not");
        }*/
        for (int i : age) {
            //the sentence is mostly saame only the word not makes it different by its presence
            System.out.printf("The Student with age %d can%s vote\n", i, (i < 18) ? " not" : "");
        }
    }
}
