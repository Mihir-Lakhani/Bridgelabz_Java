
/*
A program to find the maximum number of handshakes
among N number of students.
 */

package Java_Programming_Elements.Level_1;
import java.util.Scanner;

public class MaximumHandshakes {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the number of students: ");
        int numberOfStudents = sc.nextInt(); //Taking number of students

        //Calculate maximum possible handshakes
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        //Print the maximum number of handshakes
        System.out.printf("The maximum number of handshakes among %d students is %d",
                numberOfStudents, handshakes);
    }
}