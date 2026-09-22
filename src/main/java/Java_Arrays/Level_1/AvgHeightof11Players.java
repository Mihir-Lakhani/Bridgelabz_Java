/*
A program to find the mean height of 11 players present in a football team.
Take user input for all elements
Calc in the last and print
 */

package Java_Arrays.Level_1;
import java.util.Scanner;
public class AvgHeightof11Players {
    public static void main(String[] args){

        int num = 11;
        double heights[] = new double[num];
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        for(int i = 0; i<heights.length; i++){
            System.out.printf("Enter the height of player %d: ", i+1);
            heights[i] = sc.nextDouble();
            sum+=heights[i];
        }
        double average = sum/num;
        System.out.printf("The average height of all 11 players is: %.2f", average);
    }
}
