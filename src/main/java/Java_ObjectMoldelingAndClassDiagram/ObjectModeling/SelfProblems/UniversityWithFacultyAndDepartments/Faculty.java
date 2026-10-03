package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.UniversityWithFacultyAndDepartments;

import java.util.ArrayList;

class Faculty {

    private String facultyName;
    private Department department;

    Faculty(String facultyName){
        this.facultyName = facultyName;
    }

    String getFacultyName(){
        return facultyName;
    }
}