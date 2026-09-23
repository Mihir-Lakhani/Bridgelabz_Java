/*
11. Program to calculate the windchill temperature given the temp and the wind speed
 */

package Java_Methods.Level_1;
import java.util.Scanner;

public class WindChill {
    public static double calculateWindChill(double speed, double temp){
        double windChill = 35.74 + 0.6215 *temp + (0.4275*temp - 35.75) * Math.pow(speed, 0.16);
        return windChill;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the temperature: ");
        double temp = sc.nextDouble();

        System.out.println("Enter the speed of the wind: ");
        double speed = sc.nextDouble();

        System.out.printf("The windchill value is %.3f", calculateWindChill(speed, temp));

    }
}
