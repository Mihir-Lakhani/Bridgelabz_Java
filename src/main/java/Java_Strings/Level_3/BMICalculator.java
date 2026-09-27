/*
1. An organization took up the exercise to find the Body Mass Index (BMI)
of all the persons in a team of 10 members. For this create a program to
find the BMI and display the height, weight, BMI, and status of each individual.

Hint =>
Take user input for the person's weight (kg) and height (cm) and store it
in the corresponding 2D array of 10 rows. The first column stores the weight
and the second column stores the height in cm.
Create a method to find the BMI and status of every person given the person's
height and weight. Use BMI = weight / (height * height), where height is in metres.
Create a method that takes the 2D array of height and weight, computes the BMI
and status and returns a 2D String array.
Create a method to display height, weight, BMI and status in tabular format.
Finally, the main function takes inputs, calls the methods and displays the result.
*/

package Java_Strings.Level_3;

import java.util.Scanner;

public class BMICalculator {
    public static String[][] findBMI(double[][] person) {
        String[][] ans = new String[person.length][4];

        for (int i = 0; i < person.length; i++) {
            double weight = person[i][0];
            double heightCm = person[i][1];
            double heightM = heightCm / 100;
            double bmi = weight / (heightM * heightM);
            String status;

            if (bmi <= 18.4) status = "Underweight";
            else if (bmi <= 24.9) status = "Normal";
            else if (bmi <= 39.9) status = "Overweight";
            else status = "Obese";

            ans[i][0] = String.valueOf(heightCm);
            ans[i][1] = String.valueOf(weight);
            ans[i][2] = String.format("%.2f", bmi);
            ans[i][3] = status;
        }
        return ans;
    }

    public static void display(String[][] data) {
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + "\t" + data[i][0] + "\t\t"
                    + data[i][1] + "\t\t" + data[i][2] + "\t"
                    + data[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] person = new double[10][2];

        for (int i = 0; i < person.length; i++) {
            System.out.println("Person " + (i + 1));
            System.out.print("Enter weight in kg: ");
            person[i][0] = sc.nextDouble();
            System.out.print("Enter height in cm: ");
            person[i][1] = sc.nextDouble();
        }

        String[][] result = findBMI(person);
        display(result);
        sc.close();
    }
}