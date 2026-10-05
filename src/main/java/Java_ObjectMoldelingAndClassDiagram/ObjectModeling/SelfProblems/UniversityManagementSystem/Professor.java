package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.UniversityManagementSystem;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Professor {

    private String professorName;
    private String professorid;
    ArrayList<Course> courses = new ArrayList<>();

    Professor(String professorName, String professorid){
        this.professorName = professorName;
        this.professorid = professorid;
    }

    public String getProfessorid() { return professorid; }

    public String getProfessorName() { return professorName; }



    void teachCourse(Course course){
        if(!courses.contains(course) && course.getProfessor()==null){
            courses.add(course);
            course.setProfessor(this);
            System.out.printf("Professor %s (%s) will now Teach %s Course\n", getProfessorName(), getProfessorid(), course.getCourseName());
        }else{
            System.out.printf("Professor %s (%s) Already Teaches %s Course\n", getProfessorName(), getProfessorid(), course.getCourseName());
        }
    }


}