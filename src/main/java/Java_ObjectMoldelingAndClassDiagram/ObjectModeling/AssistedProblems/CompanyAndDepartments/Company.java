package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.AssistedProblems.CompanyAndDepartments;

import java.util.ArrayList;

class Company {
    private String name;
    private ArrayList<Department> departments = new ArrayList<>();
    private boolean deleted;

    Company(String name){
        this.name = name;
    }

    void addDepartment(String departmentName){


        for (Department department : departments){
            if (department.getName().equals(departmentName)){
                System.out.println("Department already exists.");
                return;
            }
        }

        // The company creates and keeps its own departments.
        departments.add(new Department(departmentName));
    }

    void addEmployee(String departmentName, String employeeName, String role){
        if (deleted){
            System.out.println("Cannot add an employee to a deleted company.");
            return;
        }

        for (Department department : departments){
            if (department.getName().equals(departmentName)){
                department.addEmployee(employeeName, role);
                return;
            }
        }
        System.out.println("Department not found: " + departmentName);
    }

    void displayDetails(){
        if (deleted){
            System.out.println(name + " has been deleted. No departments or employees remain.");
            return;
        }

        System.out.println("Company: " + name);
        for (Department department : departments){
            department.displayDetails();
        }
    }

    void deleteCompany(){
        for (Department department : departments){
            department.deleteDepartment();
        }
        departments.clear();
        deleted = true;
        // This removes the owned data, not the Java object itself.
        // Unreachable objects are eligible for garbage collection.
    }
}
