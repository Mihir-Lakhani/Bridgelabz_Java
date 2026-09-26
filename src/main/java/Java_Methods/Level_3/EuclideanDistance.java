/*
9. Write a program Euclidean distance between two points as well as the equation of the line using those two points. Use Math functions Math.pow() and Math.sqrt()
    Hint =>
    Take inputs for 2 points x1, y1, and x2, y2
    Method to find the Euclidean distance between two points and return the distance
    distance = (x2-x1)2 +(y2-y1)2
    Write a Method to find the equation of a line given two points and return the equation which includes the slope and the y-intercept
    The equation of a line is given by the equation y = m*x + b Where m is the slope and b is the y-intercept. So firstly compute the slope using the formulae
    m = (y2 - y1)/(x2 - x1)
    Post that compute the y-intercept b using the formulae
    b = y1 - m*x1
    Finally, return an array having slope m and y-intercept b
 */

package Java_Methods.Level_3;

import java.util.Arrays;
import java.util.Scanner;

public class EuclideanDistance {

    public static double FindDistance(double x1, double y1, double x2, double y2){

        double distance = Math.sqrt(
                Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2)
        );

        return distance;
    }

    public static double[] FindEquation(double x1, double y1, double x2, double y2){

        double m = (y2-y1)/(x2-x1);
        double b = y1 - m*x1;

        double[] equation = {m, b};

        return equation;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter x1 and y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.println("Enter x2 and y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        double distance = FindDistance(x1, y1, x2, y2);
        double[] equation = FindEquation(x1, y1, x2, y2);

        System.out.printf("The Euclidean Distance is %.2f\n", distance);

        System.out.printf(
                "The Slope is %.2f and Y-Intercept is %.2f\n",
                equation[0], equation[1]
        );

        System.out.printf(
                "The Equation of the Line is y = %.2fx + %.2f\n",
                equation[0], equation[1]
        );
    }
}