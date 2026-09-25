/*
7. Rewrite the FindTheBMI program using multi-dimensional array to store height, weight, and BMI in 2D array for all the persons
 */

package Java_Arrays.Level_2;

import java.util.Scanner;

public class FindTheBMIMultiDimArray {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        double[][] personData = new double[n][3];
        String[] status = new String[n];

        // Taking input
        for (int i = 0; i < n; i++) {

            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter weight in kg: ");
            personData[i][0] = input.nextDouble();

            System.out.print("Enter height in cm: ");
            personData[i][1] = input.nextDouble();

            // Convert cm to meters
            double heightInMeters = personData[i][1] / 100;

            // Calculate BMI
            personData[i][2] = personData[i][0] / (heightInMeters * heightInMeters);

            // Find weight status
            if (personData[i][2] < 18.5) {
                status[i] = "Underweight";
            }
            else if (personData[i][2] < 24) {
                status[i] = "Normal";
            }
            else if (personData[i][2] < 40) {
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
                    personData[i][1], personData[i][0], personData[i][2], status[i]);
        }

        input.close();
    }
}