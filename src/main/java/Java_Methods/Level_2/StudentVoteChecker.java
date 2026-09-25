/*
8. Write a program to take user input for the age of all 10 students in a class and check whether the student can vote
depending on his/her age is greater or equal to 18.

 */

package Java_Methods.Level_2;

import java.util.Arrays;
import java.util.Scanner;

public class StudentVoteChecker {
    public static boolean StudentVote(int age) {
        if (age < 18) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ages[] = new int[0];
        int index = 0;

        while (index < 10) {
            System.out.printf("Enter the age of student %d: ", index + 1);
            ages = Arrays.copyOf(ages, index + 1);
            ages[index] = sc.nextInt();
            index++;
        }

        for (int x = 0; x < ages.length; x++) {
            System.out.printf("The Student %d %s vote\n", x + 1, (StudentVote(ages[x])) ? "Can" : "Cannot");
        }
    }

}
