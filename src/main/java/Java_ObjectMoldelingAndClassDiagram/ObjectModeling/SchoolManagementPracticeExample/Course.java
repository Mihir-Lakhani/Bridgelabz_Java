package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SchoolManagementPracticeExample;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Course {

    private String courseName;
    private String courseId;
    private Teacher instructor;
    private ArrayList<Student> enrolledStudents;

    Course(String courseName, String courseId, Teacher instructor){
        this.courseName = courseName;
        this.courseId = courseId;
        this.instructor = instructor;
        this.enrolledStudents = new ArrayList<>();
    }

    void addStudent(Student student){
        enrolledStudents.add(student);
        System.out.println("The student "+student.getStudentName()+" has been Enrolled");
    }

    void showEnrolledStudents(){
        for (Student student : enrolledStudents){
            System.out.println("==========================");
            System.out.println("Course Name: "+courseName);
            System.out.println("By the Instructor: "+instructor.getInstructorName());
            System.out.println("Student Name: "+student.getStudentName());
            System.out.println("Student ID: "+student.getStudentId());
            System.out.println("==========================");
        }
    }

    Teacher getInstructor(){
        return instructor;
    }

    String getCourseName(){
        return courseName;
    }

}