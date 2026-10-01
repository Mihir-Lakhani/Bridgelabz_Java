package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SchoolManagementPracticeExample;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Teacher{

    private String teacherName;
    private String teacherId;

    Teacher(String teacherName, String teacherId){
        this.teacherName = teacherName;
        this.teacherId = teacherId;
    }

    String getInstructorName(){
        return teacherName;
    }
    String getTeacherId(){
        return teacherId;
    }

}