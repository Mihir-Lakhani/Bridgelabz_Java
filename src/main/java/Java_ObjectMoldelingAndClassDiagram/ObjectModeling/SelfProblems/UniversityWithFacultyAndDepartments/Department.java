package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.UniversityWithFacultyAndDepartments;

import java.util.ArrayList;

class Department {

    private String departmentName;
    private ArrayList<Faculty> faculties;

    Department(String departmentName){
        this.departmentName = departmentName;
        faculties = new ArrayList<>();
    }

    void addFaculty(Faculty faculty, University u){

        faculties.add(faculty);
        u.addFaculty(faculty);
    }

    void DisplayFromDepartment(){
        System.out.println(" Department Data=============");
        for (Faculty f : faculties){
            System.out.println(f.getFacultyName());
        }
    }

    String getDepartmentName(){ return departmentName; }
}