package Java_ConstructorsInstancesAndAccessModifiers.AccessModifiers;

import java.util.Scanner;

class Employee {

    public int employeeID;
    protected String department;
    private long salary;

    Employee(int employeeID) {
        this.employeeID = employeeID;
    }

    Employee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Employee ID: ");
        employeeID = sc.nextInt();
    }

    public long getSalary() {
        return salary;
    }

    public void modifySalary(long salary) {
        this.salary = salary;
    }
}

class Manager extends Employee {

    Manager() {
        super();
    }

    Manager(int employeeID) {
        super(employeeID);
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void display() {
        System.out.printf("Employee ID: %d\n", employeeID);
        System.out.printf("Department: %s\n", department);
        System.out.printf("Salary: %d\n", getSalary());
    }
}

public class EmployeeRecords {

    public static void main(String[] args) {

        Manager manager1 = new Manager();

        manager1.setDepartment("Engineering");
        manager1.modifySalary(120000);

        System.out.printf(
                "The department is now: %s\n",
                manager1.getDepartment()
        );

        manager1.display();


        Manager manager2 = new Manager(867545);

        manager2.setDepartment("Finance");
        manager2.modifySalary(210000);

        System.out.printf(
                "The department is now: %s\n",
                manager2.getDepartment()
        );

        manager2.display();
    }
}
