package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.SchoolAndStudentsWithCourses;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Mihir", "101");
        Student s2 = new Student("Harsh", "102");
        Student s3 = new Student("Rishika", "201");
        Student s4 = new Student("Shrey", "202");

        Course c1 = new Course("Engineering", "EG01");
        Course c2 = new Course("Product Manager", "PM01");

        c1.addStudent(s1);
        //s1.addCourse(c1);

        c1.addStudent(s2);
        s2.addCourse(c1);

        c1.addStudent(s3);
        s3.addCourse(c1);

        c2.addStudent(s3);
        s3.addCourse(c2);

        c2.addStudent(s1);
        s1.addCourse(c2);

        c2.addStudent(s4);
        s4.addCourse(c2);

        c1.showEnrolledStudents();

        s1.showCourses();
        s3.showCourses();

        School s = new School("SRM");

        s.addCourse(c1);
        s.addCourse(c2);

        s.showDetails();

    }
}