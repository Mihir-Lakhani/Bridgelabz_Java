/*
4. An athlete runs in a triangular park with sides provided as input by the user in meters.
If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete
 */

package Java_Methods.Level_1;

import java.util.Scanner;

public class TriangularPark {
    public double rounds(int a, int b, int c) {
        int perimeter = a + b + c;
        double laps = 5.0 / perimeter;
        return laps;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter side a: ");
        int a = sc.nextInt();

        System.out.println("Enter side b: ");
        int b = sc.nextInt();

        System.out.println("Enter side c: ");
        int c = sc.nextInt();

        TriangularPark obj = new TriangularPark();

        System.out.printf("The number of round will be %.2f", obj.rounds(a, b, c));

    }
}
