/*
Sample Program 5: University Student Management
Create a Student class to manage student data with the following features:
Static:
A static variable universityName shared across all students.
A static method displayTotalStudents() to show the number of students enrolled.
This:
Use this in the constructor to initialize name, rollNumber, and grade.
Final:
Use a final variable rollNumber for each student that cannot be changed.
Instanceof:
Check if a given object is an instance of the Student class before performing operations like displaying or updating grades.
 */

package Java_ThisStaticFinalAndInstanceOf;

import java.util.Scanner;


class Student{
    static String universityName;
    static int totalStudents = 0;
    String name;
    final int rollNumber;
    char grade;

    Scanner sc = new Scanner(System.in);

    Student(){
        totalStudents++;
        System.out.println("Enter thee roll number: ");
        rollNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter thee Name: ");
        name = sc.nextLine();
        System.out.println("Enter thee Grade: ");
        grade = sc.next().charAt(0);
        sc.nextLine();
    }

    Student(int rollNumber, String name, char grade){
        totalStudents++;
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
    }

    void display(){
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }


    public static void displayTotalStudents(){
        System.out.println("Total number of students: " + totalStudents);
    }

}

public class UniversityStudentManagement {
    public static void main(String[] args) {

        Student.universityName = "SRM University";

        Student s1 = new Student(101, "Mihir", 'A');

        if (s1 instanceof Student) {
            s1.display();
            Student.displayTotalStudents();
        }

        System.out.println("======================");

        Student s2 = new Student();

        if (s2 instanceof Student) {
            s2.display();
            Student.displayTotalStudents();
        }
    }
}