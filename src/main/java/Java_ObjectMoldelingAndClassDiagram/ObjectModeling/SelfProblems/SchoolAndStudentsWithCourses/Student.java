package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.SchoolAndStudentsWithCourses;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Student {

    private String studentName;
    private String studentId;

    private ArrayList<Course> courses = new ArrayList<>();

    Student(String studentName, String studentId){
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public String getStudentName(){
        return studentName;
    }
    public String getStudentId(){
        return studentId;
    }

    void addCourse(Course course){
        courses.add(course);
    }

    void showCourses(){
        System.out.println("Courses of " + studentName + ":");

        for(Course course : courses){
            System.out.println(course.getCourseName());
        }
    }
}