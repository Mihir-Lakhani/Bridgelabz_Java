package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.UniversityManagementSystem;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Course {

    private String courseName;
    private Professor professor;
    ArrayList<Student> students = new ArrayList<>();

    Course(String courseName) {
        this.courseName = courseName;
    }


    public String getCourseName() {
        return courseName;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addProfessor(Professor professor) {
        if (this.professor == null){
            professor.teachCourse(this);
        }else{
            System.out.printf("Course %s already has a professor%n", courseName);
        }
    }

    public void setStudent(Student student){
        students.add(student);
    }

    void addStudent(Student student){
        if(!students.contains(student)){
            student.enrollCourse(this);
        }else{
            System.out.printf("Student %s (%s) is Already Enrolled This Course%n", student.getStudentName(), student.getStudentid());
        }
    }
}
