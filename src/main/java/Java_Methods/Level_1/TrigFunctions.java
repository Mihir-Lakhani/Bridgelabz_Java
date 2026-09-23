/*
12. Write a program to calculate various trigonometric functions using Math class given an angle in degrees.
 */

package Java_Methods.Level_1;
import java.util.Scanner;


public class TrigFunctions {
    public static double[] calculateTrigonometricFunctions(double angle){
        double inRad = Math.toRadians(angle);
        double[] ans = new double[3];
        ans[0]=Math.sin(inRad);
        ans[1]=Math.cos(inRad);
        ans[2]=Math.tan(inRad);

        return ans;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the angle in degrees: ");
        double angle = sc.nextDouble();

        double[] ans = calculateTrigonometricFunctions(angle);

        System.out.printf("Sin(%.2f) = %.2f, Cos(%.2f) = %.2f, Tan(%.2f) = %.2f", angle, ans[0], angle, ans[1], angle, ans[2]);}
}
