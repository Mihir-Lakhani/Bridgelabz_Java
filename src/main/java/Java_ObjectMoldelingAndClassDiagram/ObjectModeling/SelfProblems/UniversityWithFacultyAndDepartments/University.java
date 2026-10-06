package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.UniversityWithFacultyAndDepartments;

import java.util.ArrayList;

class University {

    private String universityName;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> faculties;

    University(String universityName){
        this.universityName = universityName;

        departments = new ArrayList<>();
        faculties = new ArrayList<>();

    }

    Department addDepartment(String departmentName){
        Department department = new Department(departmentName);

        departments.add(department);

        return department;    }



    void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }

    public String getUniversityName() {
        return universityName;
    }

    void DisplayAll(){
        System.out.println("University Data=============");
        for(Department d: departments){
            System.out.println(d.getDepartmentName());
        }
        for (Faculty f : faculties){
            System.out.println(f.getFacultyName());
        }
    }


}