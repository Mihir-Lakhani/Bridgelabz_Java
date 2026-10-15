package Java_Generics;

import java.util.List;
import java.util.ArrayList;

public class MultiLevelUniversityCourseManagementSystem {

    // Generics assignment 3: each department can store a different evaluation type.
    abstract static class CourseType{
        final String name;
        abstract String evaluation();
        CourseType(String name){
            this.name = name;
        }
    }

    static class ExamCourse extends CourseType{
        @Override
        String evaluation() { return "Exam"; }
        ExamCourse(String name){
            super(name);
        }
    }
    static class AssignmentCourse extends CourseType{
        @Override
        String evaluation() { return "Assignment"; }
        AssignmentCourse(String name){
            super(name);
        }
    }
    static class ResearchCourse extends CourseType{
        @Override
        String evaluation() { return "Research"; }
        ResearchCourse(String name){
            super(name);
        }
    }


    static class Course<T extends CourseType>{
        final String department;
        List<T> courses = new ArrayList<>();

        Course(String department) {
            this.department = department;
        }
        void add(T course){
            courses.add(course);
        }

        T get(int index){
            return courses.get(index);
        }
    }

    static void Display(List<? extends CourseType> courses){
        for(CourseType course : courses){
            System.out.println(course.name + " | Evaluation: " + course.evaluation());
        }

    }

    public static void main(String[] args) {

        Course<ExamCourse> eCourses = new Course<>("Computer Science");
        ExamCourse EC1 = new ExamCourse("exam-course1");
        ExamCourse EC2 = new ExamCourse("exam-course2");
        eCourses.add(EC1);
        eCourses.add(EC2);

        Course<AssignmentCourse> aCourses = new Course<>("Design");
        AssignmentCourse AC1 = new AssignmentCourse("assignment-course1");
        AssignmentCourse AC2 = new AssignmentCourse("assignment-course2");
        aCourses.add(AC1);
        aCourses.add(AC2);

        Course<ResearchCourse> rCourses = new Course<>("Science");

        ResearchCourse RC1 = new ResearchCourse("research-course1");
        ResearchCourse RC2 = new ResearchCourse("research-course2");
        rCourses.add(RC1);
        rCourses.add(RC2);


        System.out.println(eCourses.department);
        Display(eCourses.courses);
        System.out.println(aCourses.department);
        Display(aCourses.courses);
        System.out.println(rCourses.department);
        Display(rCourses.courses);
    }
}