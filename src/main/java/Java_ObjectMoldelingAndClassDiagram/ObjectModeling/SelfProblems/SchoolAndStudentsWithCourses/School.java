package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.SchoolAndStudentsWithCourses;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class School {

    private String schoolName;
    private ArrayList<Course> courses;

    School(String schoolName){
        this.schoolName = schoolName;
        courses = new ArrayList<>();
    }

    void addCourse(Course c1){
        courses.add(c1);
    }

    void showDetails(){
        for (Course course : courses){
            System.out.println("Course: "+course.getCourseName());
            System.out.println("Students: ");
            course.showEnrolledStudents();
        }
    }

}