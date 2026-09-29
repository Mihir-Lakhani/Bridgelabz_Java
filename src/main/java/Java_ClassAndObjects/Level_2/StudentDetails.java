/*
1. Program to Simulate Student Report
Problem Statement: Create a Student class with attributes name, rollNumber, and marks. Add two methods:
To calculate the grade based on the marks.
To display the student's details and grade.
Explanation: The Student class organizes all relevant details about a student as attributes.
Methods are used to calculate the grade and provide a way to display all information.
 */

package Java_ClassAndObjects.Level_2;

import java.util.Scanner;


class Student{
    private String name;
    private int rollNumber;
    private int marks;
    private char grade;

    public void Findgrade(){
        if (marks>90){
            grade = 'A';
        }else if (marks > 80){
            grade = 'B';
        }else if (marks > 70){
            grade = 'C';
        }else{
            grade = 'F';
        }
        System.out.println("Grade Stored");
    }

    public void Display(){
        System.out.printf("Name of the Student: %s\n" +
                "Roll Number: %d\n" +
                "Marks: %d\n" +
                "Grade: %c", this.name, this.rollNumber, this.marks, this.grade);


    }

    Student(String name, int rollNumber, int marks){
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

}


public class StudentDetails {
    public static void main(String[] args) {

        Student s1 = new Student("Mihir", 46, 98);
        s1.Findgrade();
        s1.Display();
    }
}