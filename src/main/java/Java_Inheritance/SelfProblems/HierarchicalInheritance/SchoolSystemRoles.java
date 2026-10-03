/*
Program 2: School System with Different Roles (Hierarchical Inheritance)
Teacher, Student, and Staff share Person details.
Each subclass displays its own role and special attribute.
 */

package Java_Inheritance.SelfProblems.HierarchicalInheritance;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    void displayRole() {
        System.out.println("Role: Person");
        displayDetails();
    }
}

class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Teacher");
        super.displayDetails();
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    String grade;

    Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Student");
        super.displayDetails();
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    void displayRole() {
        System.out.println("Role: Staff");
        super.displayDetails();
        System.out.println("Department: " + department);
    }
}

public class SchoolSystemRoles {
    public static void main(String[] args) {
        Person[] people = {
                new Teacher("Riya", 35, "Mathematics"),
                new Student("Aman", 16, "10th"),
                new Staff("Neha", 29, "Administration")
        };

        for (Person person : people) {
            person.displayRole();
            System.out.println();
        }
    }
}
