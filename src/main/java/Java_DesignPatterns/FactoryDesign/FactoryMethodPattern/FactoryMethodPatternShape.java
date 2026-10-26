package Java_DesignPatterns.FactoryDesign.FactoryMethodPattern;

import java.util.*;

interface Shape{
    void draw();
}

class Circle implements Shape{

    @Override
    public void draw(){
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

abstract class ShapeFactory{
    public abstract Shape getShape();
}

class CircleShapeFactory extends ShapeFactory{

    public Shape getShape(){
        return new Circle();
    }
}

class RectangleShapeFactory extends ShapeFactory{

    public Shape getShape(){
        return new Rectangle();
    }
}

public class FactoryMethodPatternShape {
    public static void main(String[] args) {

        ShapeFactory circleFactory = new CircleShapeFactory();
        ShapeFactory rectangleFactory = new RectangleShapeFactory();

        Shape circle1 = circleFactory.getShape();
        Shape rectangle1 = rectangleFactory.getShape();

        circle1.draw();
        rectangle1.draw();

    }
}