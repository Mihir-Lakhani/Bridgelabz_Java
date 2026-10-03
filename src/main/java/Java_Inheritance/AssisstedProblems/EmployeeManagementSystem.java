/*
Employee Management System
Create an Employee class with Manager, Developer, and Intern subclasses.
Each subclass has its own attribute and displays it with the employee details.
 */

package Java_Inheritance.AssisstedProblems;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.printf("Salary: Rs.%.2f%n", salary);
    }
}

class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    int internshipMonths;

    Intern(String name, int id, double salary, int internshipMonths) {
        super(name, id, salary);
        this.internshipMonths = internshipMonths;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Duration: " + internshipMonths + " months");
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee[] employees = {
                new Manager("Mihir", 101, 75000, 5),
                new Developer("Riya", 102, 55000, "Java"),
                new Intern("Aman", 103, 15000, 6)
        };

        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println();
        }
    }
}
