/*
11. Write a program Quadratic to find the roots of the equation
ax^2 + bx + c using Math.pow() and Math.sqrt().
 */

package Java_Methods.Level_2;

import java.util.Arrays;
import java.util.Scanner;

public class Quadratic {

    //Method to find the roots of quadratic equation
    public static double[] findRoots(double a, double b, double c){

        //Calculate discriminant
        double delta = Math.pow(b, 2) - (4 * a * c);

        //If delta is positive there are two roots
        if(delta > 0){

            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);

            return new double[]{root1, root2};

            //If delta is zero there is only one root
        }else if(delta == 0){

            double root = -b / (2 * a);

            return new double[]{root};

            //If delta is negative return empty array
        }else{

            return new double[0];
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value of a: ");
        double a = sc.nextDouble();

        System.out.println("Enter value of b: ");
        double b = sc.nextDouble();

        System.out.println("Enter value of c: ");
        double c = sc.nextDouble();

        //Call method to find roots
        double[] roots = findRoots(a, b, c);

        //Display roots
        if(roots.length == 0){

            System.out.println("There are no real roots");

        }else{

            System.out.println("The roots are: " + Arrays.toString(roots));
        }
    }
}