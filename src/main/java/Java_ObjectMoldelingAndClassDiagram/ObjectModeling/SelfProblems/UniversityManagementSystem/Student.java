package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.UniversityManagementSystem;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Student {

    private String studentName;
    private String studentid;
    private Professor professor;
    ArrayList<Course> courses = new ArrayList<>();

    Student(String studentName, String studentid){
        this.studentName = studentName;
        this.studentid = studentid;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getStudentName() {
        return studentName;
    }

    void enrollCourse(Course course){
        courses.add(course);
    }

    void assignProfessor(Professor professor){
        professor.addStudent(this);
        this.professor = professor;

    }
}