package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SchoolManagementPracticeExample;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Mihir", "RA046");
        Student s2 = new Student("Harsh", "RA048");
        Student s3 = new Student("Rishika", "RA049");
        Student s4 = new Student("Shrey", "RA050");

        Teacher t1 = new Teacher("Murugaaanandam", "FA021");
        Teacher t2 = new Teacher("Venkatesh", "FA022");

        Course c1 = new Course("Engineering", "CA901", t1);
        Course c2 = new Course("Product Manager", "CA902", t2);

        c1.addStudent(s1);
        c1.addStudent(s2);
        c2.addStudent(s3);
        c2.addStudent(s4);

        c1.showEnrolledStudents();
        c2.showEnrolledStudents();

        School sc1 = new School("S.R.M. Institute of Science and Technology");

        sc1.addCourse(c1);
        sc1.addCourse(c2);

        sc1.displayCoursesAndInstructors();

    }
}