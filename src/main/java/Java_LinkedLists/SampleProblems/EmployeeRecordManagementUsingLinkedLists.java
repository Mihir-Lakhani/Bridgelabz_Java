package Java_LinkedLists.SampleProblems;

import java.util.Scanner;

public class EmployeeRecordManagementUsingLinkedLists {

    private static class EmployeeNode {
        String id;
        String name;
        String department;
        int salary;
        EmployeeNode next = null;

        EmployeeNode(String id, String name, String department, int salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    private EmployeeNode head;

    // Add employee at the beginning
    void addHeadElement(String id, String name, String department, int salary) {

        EmployeeNode newEmployee = new EmployeeNode(id, name, department, salary);

        newEmployee.next = head;
        head = newEmployee;
    }

    // Add employee at the end
    void addTailElement(String id, String name, String department, int salary) {

        EmployeeNode newEmployee = new EmployeeNode(id, name, department, salary);

        // If the list is empty
        if (head == null) {
            head = newEmployee;
            return;
        }

        EmployeeNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newEmployee;
    }

    // Add employee at a particular index
    void addMidElement(String id, String name, String department, int salary, int index) {

        if (index < 0) {
            System.out.println("Invalid index.");
            return;
        }

        // If index is 0, add at beginning
        if (index == 0) {
            addHeadElement(id, name, department, salary);
            return;
        }

        if (head == null) {
            System.out.println("List is empty. Only index 0 is valid.");
            return;
        }

        EmployeeNode newEmployee =
                new EmployeeNode(id, name, department, salary);

        EmployeeNode current = head;

        int count = 0;

        while (count < index - 1 && current != null) {
            current = current.next;
            count++;
        }

        // Index is greater than the size of the list
        if (current == null) {
            System.out.println("Invalid index.");
            return;
        }

        newEmployee.next = current.next;
        current.next = newEmployee;
    }

    // Delete employee from the beginning
    void deleteHeadElement() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        head = head.next;
    }

    // Delete employee from the end
    void deleteTailElement() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If there is only one node
        if (head.next == null) {
            head = null;
            return;
        }

        EmployeeNode temp = head.next;
        EmployeeNode current = head;

        while (temp.next != null) {
            current = temp;
            temp = temp.next;
        }

        current.next = null;
    }

    // Delete employee from a particular index
    void deleteMidElement(int index) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (index < 0) {
            System.out.println("Invalid index.");
            return;
        }

        // If index is 0
        if (index == 0) {
            deleteHeadElement();
            return;
        }

        EmployeeNode temp = head.next;
        EmployeeNode current = head;

        int count = 1;

        while (count < index && temp != null) {
            current = temp;
            temp = temp.next;
            count++;
        }

        // Index does not exist
        if (temp == null) {
            System.out.println("Invalid index.");
            return;
        }

        current.next = temp.next;
    }

    // Display all employees
    void traverse() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        EmployeeNode temp = head;

        while (temp != null) {

            System.out.println("==============================");
            System.out.printf(
                    "ID: %s\nName: %s\nDepartment: %s\nSalary: %d\n",
                    temp.id,
                    temp.name,
                    temp.department,
                    temp.salary
            );
            System.out.println("==============================");

            if (temp.next != null) {
                System.out.println("|\n|\n|\nV\n");
            }

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        EmployeeRecordManagementUsingLinkedLists list1 =
                new EmployeeRecordManagementUsingLinkedLists();

        // Initial employee
        list1.head =
                new EmployeeNode("E046", "Mihir", "NWC", 1500000);

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE RECORD MANAGEMENT =====");
            System.out.println("1. Add Element at the Beginning");
            System.out.println("2. Add Element at the End");
            System.out.println("3. Add Element at the index");
            System.out.println("4. Remove Head Element");
            System.out.println("5. Remove Last Element");
            System.out.println("6. Remove Element at the index");
            System.out.println("7. Traverse");
            System.out.println("8. End");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("Enter the id: ");
                    String id = sc.next();

                    sc.nextLine();

                    System.out.println("Enter the name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter the department: ");
                    String department = sc.next();

                    sc.nextLine();

                    System.out.println("Enter the salary: ");
                    int salary = sc.nextInt();

                    sc.nextLine();

                    list1.addHeadElement(
                            id, name, department, salary
                    );

                    break;

                case 2:

                    System.out.println("Enter the id: ");
                    id = sc.next();

                    sc.nextLine();

                    System.out.println("Enter the name: ");
                    name = sc.nextLine();

                    System.out.println("Enter the department: ");
                    department = sc.next();

                    sc.nextLine();

                    System.out.println("Enter the salary: ");
                    salary = sc.nextInt();

                    sc.nextLine();

                    list1.addTailElement(
                            id, name, department, salary
                    );

                    break;

                case 3:

                    System.out.println("Enter the id: ");
                    id = sc.next();

                    sc.nextLine();

                    System.out.println("Enter the name: ");
                    name = sc.nextLine();

                    System.out.println("Enter the department: ");
                    department = sc.next();

                    sc.nextLine();

                    System.out.println("Enter the salary: ");
                    salary = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Enter the index: ");
                    int index = sc.nextInt();

                    list1.addMidElement(
                            id, name, department, salary, index
                    );

                    break;

                case 4:

                    list1.deleteHeadElement();

                    break;

                case 5:

                    list1.deleteTailElement();

                    break;

                case 6:

                    System.out.println("Enter the index: ");
                    index = sc.nextInt();

                    list1.deleteMidElement(index);

                    break;

                case 7:

                    list1.traverse();

                    break;

                case 8:

                    System.out.println("THANK YOU....!!");

                    break;

                default:

                    System.out.println("Enter the correct choice");
            }

        } while (choice != 8);

        sc.close();
    }
}