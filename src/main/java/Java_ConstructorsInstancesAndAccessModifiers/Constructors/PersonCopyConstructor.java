/*
1. Create a Person class with a copy constructor that clones another person's attributes.
*/

package Java_ConstructorsInstancesAndAccessModifiers.Constructors;

class Person {
    private String name;
    private int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person other) { //other is a parameter
        this.name = other.name;
        this.age = other.age;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class PersonCopyConstructor {
    public static void main(String[] args) {

        Person p1 = new Person("Mihir", 21);

        // Creating p2 as a copy of p1
        Person p2 = new Person(p1);

        System.out.println("Original Person:");
        p1.display();

        System.out.println("\nCopied Person:");
        p2.display();
    }
}