package Java_Generics;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MultiLevelUniversityCourseManagementSystem {

    abstract static class CourseType{
        final String name;
        CourseType(String name){
            this.name = name;
        }
    }

    static class ExamCourse extends CourseType{
        ExamCourse(String name){
            super(name);
        }
    }
    static class AssignmentCourse extends CourseType{
        AssignmentCourse(String name){
            super(name);
        }
    }
    static class ResearchCourse extends CourseType{
        ResearchCourse(String name){
            super(name);
        }
    }


    static class Course<T extends CourseType>{
        List<T> courses = new ArrayList<>();
        void add(T course){
            courses.add(course);
        }

        T get(int index){
            return courses.get(index);
        }
    }

    static <T extends CourseType>void Display(List<T> courses){
        for(CourseType course : courses){
            System.out.println(course.name);
        }

    }

    public static void main(String[] args) {

        Course<ExamCourse> eCourses = new Course<>();
        //courses.add(new ExamCourse("exam-course"));
        ExamCourse EC1 = new ExamCourse("exam-course1");
        ExamCourse EC2 = new ExamCourse("exam-course2");
        eCourses.add(EC1);
        eCourses.add(EC2);

        Course<AssignmentCourse> aCourses = new Course<>();
        AssignmentCourse AC1 = new AssignmentCourse("assignment-course1");
        AssignmentCourse AC2 = new AssignmentCourse("assignment-course2");
        aCourses.add(AC1);
        aCourses.add(AC2);

        Course<ResearchCourse> rCourses = new Course<>();

        ResearchCourse RC1 = new ResearchCourse("research-course1");
        ResearchCourse RC2 = new ResearchCourse("research-course2");
        rCourses.add(RC1);
        rCourses.add(RC2);


        Display(eCourses.courses);
        Display(aCourses.courses);
        Display(rCourses.courses);
    }
}