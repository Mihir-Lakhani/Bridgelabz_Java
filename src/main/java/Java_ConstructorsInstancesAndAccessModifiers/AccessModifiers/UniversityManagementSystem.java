package Java_ConstructorsInstancesAndAccessModifiers.AccessModifiers;

import java.util.Scanner;

class Student{
    protected String name;
    final public int rollNumber;
    private double CGPA;

    Student(int rollNumber){
        this.rollNumber=rollNumber;
    }

    Student(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Roll Number: ");
        rollNumber = input.nextInt();
    }

    public void ModifyCGPA(double CGPA){
        this.CGPA=CGPA;
    }


}

class PostgraduateStudent extends Student{
    PostgraduateStudent(String name, int rollNumber){
        super(rollNumber);
        this.name = name;
    }
    PostgraduateStudent(String name){
        super();
        this.name=name;
    }
    PostgraduateStudent(int rollNumber){
        super(rollNumber);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Name: ");
        name = input.next();
    }
    PostgraduateStudent(){
        super();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Name: ");
        name = input.next();
    }
}


public class UniversityManagementSystem {
    public static void main(String[] args) {

        PostgraduateStudent s1 = new PostgraduateStudent( );
        s1.ModifyCGPA(8.36);


    }
}