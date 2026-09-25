/*
6.  find the Body Mass Index (BMI) of all the persons in the team.
For this create a program to find the BMI and display the height, weight, BMI and status of each individual
 */

package Java_Arrays.Level_2;
import java.util.Scanner;

public class FindTheBMI {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        // Taking input
        for (int i = 0; i < n; i++) {

            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter weight in kg: ");
            weight[i] = input.nextDouble();

            System.out.print("Enter height in cm: ");
            height[i] = input.nextDouble();

            // Convert cm to meters
            double heightInMeters = height[i] / 100;

            // Calculate BMI
            bmi[i] = weight[i] / (heightInMeters * heightInMeters);

            // Find weight status
            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            }
            else if (bmi[i] < 25) {
                status[i] = "Normal";
            }
            else if (bmi[i] < 30) {
                status[i] = "Overweight";
            }
            else {
                status[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\nHeight\tWeight\tBMI\tStatus");

        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s%n",
                    height[i], weight[i], bmi[i], status[i]);
        }

        input.close();
    }
}