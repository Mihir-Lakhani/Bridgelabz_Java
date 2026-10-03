/*
Animal Hierarchy
Description: Create a hierarchy where Animal is the superclass, and Dog, Cat, and Bird are subclasses. Each subclass has a unique behavior.
Tasks:
Define a superclass Animal with attributes name and age, and a method makeSound().
Define subclasses Dog, Cat, and Bird, each with a unique implementation of makeSound().
Goal: Learn basic inheritance, method overriding, and polymorphism with simple classes.
 */

package Java_Inheritance.AssisstedProblems;

class Animal{
    String name;
    int age;

    Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    void makeSound(){
        System.out.println("Animal Made Sound");
    }
}

class Dog extends Animal{

    Dog(String name, int age){
        super(name, age);
    }

    @Override
    void makeSound(){
        super.makeSound();
        System.out.println("Dog Made Sound");
    }
}
class Cat extends Animal{

    Cat(String name, int age){
        super(name, age);
    }

    @Override
    void makeSound(){
        super.makeSound();
        System.out.println("Cat Made Sound");
    }
}
class Bird extends Animal{

    Bird(String name, int age){
        super(name, age);
    }

    @Override
    void makeSound(){
        super.makeSound();
        System.out.println("Bird Made Sound");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {

        Animal animal = new Animal("janwar", 30);
        System.out.println(animal.name);

        Dog dog = new Dog("wofu", 7);
        System.out.println(dog.name);

        Cat cat = new Cat("mausi", 3);
        System.out.println(cat.name);

        Bird bird = new Bird("phurr", 12);
        System.out.println(bird.name);

    }
}