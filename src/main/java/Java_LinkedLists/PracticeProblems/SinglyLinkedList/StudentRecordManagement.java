/*
1. Singly Linked List: Student Record Management
Problem Statement: Create a program to manage student records using a singly linked list. Each node will store information about a student, including their Roll Number, Name, Age, and Grade. Implement the following operations:
Add a new student record at the beginning, end, or at a specific position.
Delete a student record by Roll Number.
Search for a student record by Roll Number.
Display all student records.
Update a student's grade based on their Roll Number.
Hint:
Use a singly linked list where each node contains student information and a pointer to the next node.
The head of the list will represent the first student, and the last node’s next pointer will be null.
Update the next pointers when inserting or deleting nodes.
 */

package Java_LinkedLists.PracticeProblems.SinglyLinkedList;

public class StudentRecordManagement {

    private static class Student{
        private String name;
        final private String rollNumber;
        private int age;
        char grade;
        Student next = null;

        Student(String name, String rollNumber, int age, char grade){
            this.name = name;
            this.rollNumber = rollNumber;
            this.age = age;
            this.grade = grade;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public void DisplayDetails() {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Age: " + age);
            System.out.println("Grade: " + grade);
        }
    }


    private static Student head;

    static void addBeginning(String name, String rollNumber, int age, char grade){
        Student newStudent = new Student(name, rollNumber, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    static void addEnd(String name, String rollNumber, int age, char grade){
        Student newStudent = new Student(name, rollNumber, age, grade);

        if (head == null) {
            head = newStudent;
            return;
        }

        Student current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = newStudent;
    }

    static void addMid(String name, String rollNumber, int age, char grade, int index){
        Student newStudent = new Student(name, rollNumber, age, grade);

        if (head == null) {
            head = newStudent;
            return;
        }

        Student current = head;
        while(index != 0){
            current = current.next;
            index--;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }

    static void delete(String rollNumber) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.getRollNumber().equals(rollNumber)) {
            head = head.next;
            System.out.printf("Deleted Student with roll number: %s%n", rollNumber);
            return;
        }

        Student current = head;
        while (current.next != null
                && !current.next.getRollNumber().equals(rollNumber)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.printf("No Student found with roll number: %s%n", rollNumber);
            return;
        }
        current.next = current.next.next;
        System.out.printf("Deleted Student with roll number: %s%n", rollNumber);
    }

    static void search(String rollNumber) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Student current = head;

        while (current != null) {
            if (current.getRollNumber().equals(rollNumber)) {
                current.DisplayDetails();
                return;
            }
            current = current.next;
        }

        System.out.printf("No Student found with roll number: %s%n", rollNumber);
    }

    static void displayAll() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Student current = head;

        while (current != null) {
            current.DisplayDetails();
            System.out.println("--------------------");
            current = current.next;
        }
    }

    static void updateGrade(String rollNumber, char newGrade) {
        Student current = head;

        while (current != null) {
            if (current.getRollNumber().equals(rollNumber)) {
                current.grade = newGrade;
                System.out.printf(
                        "Updated grade for %s to %c%n",
                        rollNumber, newGrade
                );
                return;
            }
            current = current.next;
        }

        System.out.printf("No Student found with roll number: %s%n", rollNumber);
    }


    public static void main(String[] args) {

        // Add students at the beginning.
        addBeginning("Mihir Lakhani", "S101", 21, 'A');
        addBeginning("Shrey Modi", "S102", 20, 'B');

        // Add students at the end.
        addEnd("Rishika Sharma", "S103", 21, 'A');
        addEnd("Harsh Sarode", "S104", 22, 'C');

        // Your current addMid() inserts AFTER the given zero-based index.
        addMid("Aarav Patel", "S105", 20, 'B', 1);

        System.out.println("=== All Student Records ===");
        displayAll();

        System.out.println("\n=== Search for S103 ===");
        search("S103");

        System.out.println("\n=== Update S104's Grade ===");
        updateGrade("S104", 'A');
        search("S104");

        System.out.println("\n=== Delete S105 ===");
        delete("S105");

        System.out.println("\n=== Delete the First Student ===");
        delete("S102");

        System.out.println("\n=== Search for a Missing Student ===");
        search("S999");

        System.out.println("\n=== Remaining Student Records ===");
        displayAll();
    }
}