package Java_DesignPatterns.FactoryDesign.SingleFactoryPattern;

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

class Rectangle implements Shape{

    @Override
    public void draw(){
        System.out.println("Drawing Rectangle");
    }
}

class ShapeFactory{

    Shape getShape(String type){
        if (type.equalsIgnoreCase("circle")){
            return new Circle();
        } else if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}


public class SingleFactoryPatternDraw {
    public static void main(String[] args) {

        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.getShape("circle");
        Shape rectangle = factory.getShape("rectangle");

        circle.draw();
        rectangle.draw();
    }
}