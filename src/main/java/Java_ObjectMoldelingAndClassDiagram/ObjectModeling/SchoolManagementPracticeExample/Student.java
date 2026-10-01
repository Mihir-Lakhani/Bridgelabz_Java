package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SchoolManagementPracticeExample;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Student {

    private String studentName;
    private String studentId;

    Student(String studentName, String studentId){
        this.studentName = studentName;
        this.studentId = studentId;
    }

    String getStudentName(){
        return studentName;
    }
    String getStudentId(){
        return studentId;
    }

}