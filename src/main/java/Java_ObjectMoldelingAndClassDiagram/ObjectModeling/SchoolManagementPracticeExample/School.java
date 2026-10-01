package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SchoolManagementPracticeExample;

import java.util.ArrayList;
import java.util.Scanner;

public class School {

    private String schoolName;
    private ArrayList<Course> courses;

    School(String schoolName) {

        this.schoolName = schoolName;
        courses = new ArrayList<>();
    }

    void addCourse(Course course){
        courses.add(course);
    }
    String getSchoolName(){
        return schoolName;
    }
    void displayCoursesAndInstructors(){
        System.out.println("====="+schoolName+"=====");
        System.out.println("Courses\t\t\tInstructors");
        for(Course course : courses){
            System.out.println(course.getCourseName()+"\t\t"+course.getInstructor().getInstructorName());
        }
    }
}