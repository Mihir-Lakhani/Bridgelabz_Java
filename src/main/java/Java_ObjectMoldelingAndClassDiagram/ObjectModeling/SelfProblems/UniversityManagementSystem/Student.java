package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.UniversityManagementSystem;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Student {

    private String studentName;
    private String studentid;
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
        if (!courses.contains(course)){
        courses.add(course);
        course.setStudent(this);
            System.out.printf("Student %s (%s) is now Enrolled %s Course\n", getStudentName(), getStudentid(), course.getCourseName());
        }else{
            System.out.printf("Student %s (%s) is Already Enrolled %s Course\n", getStudentName(), getStudentid(), course.getCourseName());
        }
    }


}