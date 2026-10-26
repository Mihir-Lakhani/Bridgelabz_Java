package Java_DesignPatterns.AbstractFactory;

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }

}

interface ShapeColor {
    void apply();
}

class RedColor implements ShapeColor {
    public void apply() {
        System.out.println("Applying Red");
    }
}

class BlueColor implements ShapeColor {
    public void apply() {
        System.out.println("Applying Blue");
    }
}

// Abstract Factory: creates a family of products
interface ShapeFactory {
    Shape createShape();
    ShapeColor createColor();
}

// Family: Circle + Red
class CircleFactory implements ShapeFactory {
    public Shape createShape() {
        return new Circle();
    }

    public ShapeColor createColor() {
        return new RedColor();
    }
}

// Family: Rectangle + Blue
class RectangleFactory implements ShapeFactory {
    public Shape createShape() {
        return new Rectangle();
    }

    public ShapeColor createColor() {
        return new BlueColor();
    }
}

public class AbstractFactoryPatternShape {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();

        Shape shape1 = circleFactory.createShape();
        ShapeColor color1 = circleFactory.createColor();

        shape1.draw();
        color1.apply();

        System.out.println("=================");

        ShapeFactory rectangleFactory = new RectangleFactory();

        Shape shape2 = rectangleFactory.createShape();
        ShapeColor color2 = rectangleFactory.createColor();

        shape2.draw();
        color2.apply();
    }
}