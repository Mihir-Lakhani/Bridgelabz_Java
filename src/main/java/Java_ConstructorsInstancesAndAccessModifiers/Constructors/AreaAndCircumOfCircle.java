/*
2. Write a Circle class with a radius attribute.
Use constructor chaining to initialize radius with default and user-provided values.
 */

package Java_ConstructorsInstancesAndAccessModifiers.Constructors;

import java.util.Scanner;

class Circle{
    private double radius;

    public double getRadius() {return this.radius; }

    Circle() {this(1.0);}

    Circle(double radius){
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


        Circle c1 = new Circle();
        Circle c2 = new Circle(5.3);
        System.out.printf("The Area of Circle of radius %f is %.3f\n", c1.getRadius(), c1.getArea());
        System.out.printf("The Circumference of Circle of radius %f is %.3f\n", c1.getRadius(), c1.getCircum());

        System.out.printf("The Area of Circle of radius %f is %.3f\n", c2.getRadius(), c2.getArea());
        System.out.printf("The Circumference of Circle of radius %f is %.3f", c2.getRadius(), c2.getCircum());
    }
}