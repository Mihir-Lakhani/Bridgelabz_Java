/*
12. Create a program to take input marks of students in 3 subjects physics, chemistry, and maths. Compute the total, average, and the percentage score
    Hint =>
    Take input for the number of students
    Write a method to generate random 2-digit scores for Physics, Chemistry, and Math (PCM) for the students and return the scores. This method returns a 2D array with PCM scores for all students
    Write a Method to calculate the total, average, and percentages for each student and return a 2D array with the corresponding values. Please ensure to round off the values to 2 Digits using the Math.round() method.
    Finally, write a Method to display the scorecard of all students with their scores, total, average, and percentage in a tabular format using "\t".
 */

package Java_Methods.Level_3;

import java.util.Scanner;

public class StudentScoreCard {

    public static int[][] GenerateScores(int n){

        int[][] scores = new int[n][3];

        for(int i=0; i<n; i++){

            for(int j=0; j<3; j++){

                //Random 2-digit marks
                scores[i][j] = (int)(Math.random()*90)+10;
            }
        }

        return scores;
    }


    public static double[][] CalculateResult(int[][] scores){

        double[][] result = new double[scores.length][3];

        for(int i=0; i<scores.length; i++){

            double total = scores[i][0] + scores[i][1] + scores[i][2];

            double average = total/3.0;

            double percentage = (total/300.0)*100;

            average = Math.round(average*100.0)/100.0;
            percentage = Math.round(percentage*100.0)/100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }

        return result;
    }


    public static String FindGrade(double percentage){

        if(percentage>=80){
            return "A";
        }
        else if(percentage>=70){
            return "B";
        }
        else if(percentage>=60){
            return "C";
        }
        else if(percentage>=50){
            return "D";
        }
        else if(percentage>=40){
            return "E";
        }
        else{
            return "R";
        }
    }


    public static void DisplayScoreCard(int[][] scores, double[][] result){

        System.out.println(
                "Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade"
        );

        for(int i=0; i<scores.length; i++){

            System.out.printf(
                    "%d\t%d\t%d\t\t%d\t%d\t%.2f\t%.2f\t\t%s\n",
                    i+1,
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    (int)result[i][0],
                    result[i][1],
                    result[i][2],
                    FindGrade(result[i][2])
            );
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();

        int[][] scores = GenerateScores(n);

        double[][] result = CalculateResult(scores);

        DisplayScoreCard(scores, result);

        sc.close();
    }
}