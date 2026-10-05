package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.AssistedProblems.CompanyAndDepartments;

import java.util.ArrayList;

class Department {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();

    Department(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    void addEmployee(String employeeName, String role){
        // Employees are created here and are not shared with other departments.
        employees.add(new Employee(employeeName, role));
    }

    void displayDetails(){
        System.out.println("Department: " + name);
        for (Employee employee : employees){
            employee.displayDetails();
        }
    }

    void deleteDepartment(){
        employees.clear();
    }

    // Only Department can directly use this employee class.
    private static class Employee {
        private String name;
        private String role;

        Employee(String name, String role){
            this.name = name;
            this.role = role;
        }

        void displayDetails(){
            System.out.println("  " + name + " - " + role);
        }
    }
}
