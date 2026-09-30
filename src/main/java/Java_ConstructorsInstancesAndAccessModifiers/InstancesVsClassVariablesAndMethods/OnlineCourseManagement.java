package Java_ConstructorsInstancesAndAccessModifiers.InstancesVsClassVariablesAndMethods;

import java.util.Scanner;

class Course{
    String courseName;
    int duration;
    int fee;
    static String instituteName;


    Course(String courseName, int duration, int fee){
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails(){
        System.out.printf("Course Name: %s\n", courseName);
        System.out.printf("Course Duration: %d\n", duration);
        System.out.printf("Course Fee: %d\n", fee);
    }

    public void updateInstituteName(String institutename){
        Course.instituteName = institutename;
    }

}

public class OnlineCourseManagement {
    public static void main(String[] args) {

        Course c1 = new Course("Product Manager", 4, 40000);
        c1.displayCourseDetails();
        c1.updateInstituteName("NextLeap");
    }
}