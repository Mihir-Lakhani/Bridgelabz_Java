/*
1. Program to Display Employee Details
Problem Statement: Write a program to create an Employee class with attributes name, id, and salary.
Add a method to display the details.
 */

package Java_ClassAndObjects.Level_1;

class Employee{

    private String name;
    private int id;
    private int salary;

    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }

    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }
    public int getSalary(){
        return this.salary;
    }

    public void displayDetails(){
        System.out.printf("Name: %s\nID: %d\nSalary: %d\n", this.name, this.id, this.salary);
    }
}

public class EmployeeDetails{

    public static void main(String[] args){

        Employee E1 = new Employee();
        System.out.println("No Values Set Yet");
        E1.displayDetails();

        E1.setName("Mihir");
        E1.setId(46);
        E1.setSalary(1500000);

        E1.displayDetails();
    }
}