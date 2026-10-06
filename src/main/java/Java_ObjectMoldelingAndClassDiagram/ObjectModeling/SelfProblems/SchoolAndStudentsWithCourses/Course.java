package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.SchoolAndStudentsWithCourses;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Course {

    private String courseName;
    private String courseId;
    private ArrayList<Student> enrolledStudents = new ArrayList<>();


    Course(String courseName, String courseId){
        this.courseName = courseName;
        this.courseId = courseId;
    }

    void addStudent(Student s1){

        enrolledStudents.add(s1);
        s1.addCourse(this);
    }

    void showEnrolledStudents(){
        System.out.println("====="+courseName+"=====");
        for(Student student : enrolledStudents){
            System.out.println("Name: "+student.getStudentName());
            System.out.println("ID: "+student.getStudentId());
        }
    }

    public String getCourseName(){
        return courseName;
    }
    public String getCourseId(){
        return courseId;
    }
}