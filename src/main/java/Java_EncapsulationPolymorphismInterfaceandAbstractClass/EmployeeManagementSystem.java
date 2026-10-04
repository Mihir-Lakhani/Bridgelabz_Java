/*
1. Employee Management System
Description: Build an employee management system with the following requirements:
Use an abstract class Employee with fields like employeeId, name, and baseSalary.
Provide an abstract method calculateSalary() and a concrete method displayDetails().
Create two subclasses: FullTimeEmployee and PartTimeEmployee, implementing calculateSalary() based on work hours or fixed salary.
Use encapsulation to restrict direct access to fields and provide getter and setter methods.
Create an interface Department with methods like assignDepartment() and getDepartmentDetails().
Ensure polymorphism by processing a list of employees and displaying their details using the Employee reference.
 */

package Java_EncapsulationPolymorphismInterfaceandAbstractClass;

import java.util.*;


abstract class Employee{
    private String employeeId;
    private String name;
    private int baseSalary;


    Employee(String name, String id, int baseSalary){
        this.name = name;
        this.employeeId = id;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract int CalculateSalary();

    public void DisplayDetails(){
        System.out.println("Name: "+ getName());
        System.out.println("Id: "+ getEmployeeId());
        System.out.println("Base Salary: "+ getBaseSalary());
    }
}

interface Department{


    void assignDepartment(String department);

    void getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department{

    private String department;
    int workHours = 7;
    int finalSalary;

    FullTimeEmployee(String name, String id, int baseSalary){
        super(name, id, baseSalary);
    }

    @Override
    int CalculateSalary() {
        return getBaseSalary() + 5000*workHours;
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public void getDepartmentDetails() {
        System.out.println("Department: " + department);
    }

    @Override
    public void DisplayDetails(){
        super.DisplayDetails();
        System.out.println("Department: "+department);
    }
}

class PartTimeEmployee extends Employee implements Department{

    private String department;
    int workHours;
    int finalSalary;

    PartTimeEmployee(String name, String id, int baseSalary, int workHours){
        super(name, id, baseSalary);
        this.workHours = workHours;
    }

    @Override
    int CalculateSalary() {
        return getBaseSalary() + 5000*workHours;
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public void getDepartmentDetails() {
        System.out.println("Department: " + department);
    }

    @Override
    public void DisplayDetails(){
        super.DisplayDetails();
        System.out.println("Department: "+department);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {

        FullTimeEmployee fullTime =
                new FullTimeEmployee("Mihir", "E101", 30000);
        fullTime.assignDepartment("Engineering");

        PartTimeEmployee partTime =
                new PartTimeEmployee("Rishika", "E102", 10000, 4);
        partTime.assignDepartment("Marketing");

        List<Employee> employees = new ArrayList<>();
        employees.add(fullTime);
        employees.add(partTime);

        for (Employee employee : employees) {
            employee.DisplayDetails();
            System.out.println(
                    "Final Salary: " + employee.CalculateSalary()
            );
            System.out.println();
        }
    }
}