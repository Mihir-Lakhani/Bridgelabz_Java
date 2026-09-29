/*
2. Program to Compute Area of a Circle
Problem Statement: Write a program to create a Circle class with an attribute radius.
Add methods to calculate and display the area and circumference of the circle.

 */

package Java_ClassAndObjects.Level_1;

import java.util.Scanner;

class Circle{
    private int radius;

    public void setRadius(int radius){
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getCircum(){
        return 2 * Math.PI * radius;
    }

}

public class AreaAndCircumOfCircle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Radius of the circle: ");
        int radius = sc.nextInt();
        Circle c1 = new Circle();
        c1.setRadius(radius);
        System.out.printf("The Area of Circle of radius %d is %.3f\n", radius, c1.getArea());
        System.out.printf("The Circumference of Circle of radius %d is %.3f", radius, c1.getCircum());

    }
}