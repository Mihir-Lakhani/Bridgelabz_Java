/*
Sample Program 3: Employee Management System
Design an Employee class with the following features:
Static:
A static variable companyName shared by all employees.
A static method displayTotalEmployees() to show the total number of employees.
This:
Use this to initialize name, id, and designation in the constructor.
Final:
Use a final variable id for the employee ID, which cannot be modified after assignment.
Instanceof:
Check if a given object is an instance of the Employee class before printing the employee details.
 */

package Java_ThisStaticFinalAndInstanceOf;

import java.util.Scanner;


class Employee{
    static String companyName;
    static int totalEmployees;
    String name;
    String designation;
    final int id;

    Employee(int id, String name, String designation){
        this.id = id;
        this.name=name;
        this.designation=designation;
        totalEmployees++;
    }
    Scanner sc = new Scanner(System.in);

    Employee(){
        System.out.println("Enter the id: ");
        id = sc.nextInt();
        sc.nextLine();   // consume leftover Enter
        System.out.println("Enter the name: ");
        name = sc.nextLine();
        System.out.println("Enter the Designation: ");
        designation = sc.next();
        totalEmployees++;
    }



    public static void displayTotalEmployee(){
        System.out.println("Total number of employees: "+ totalEmployees);
    }
}


public class EmployeeManagementSystem {
    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Mihir", "Engineer");
        if (e1 instanceof Employee){
            Employee.displayTotalEmployee();
        }
        Employee e2 = new Employee();
        if (e2 instanceof Employee){
            Employee.displayTotalEmployee();
        }
    }
}