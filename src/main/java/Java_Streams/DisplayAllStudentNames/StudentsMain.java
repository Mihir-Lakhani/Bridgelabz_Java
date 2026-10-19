package Java_Streams.DisplayAllStudentNames;

import java.util.*;

public class StudentsMain {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Mihir", "Lakhani", 94));
        students.add(new Student("Rishika", "Sahu", 39));
        students.add(new Student("Shrey", "Modi", 78));

        students.stream()
                .forEach(x -> System.out.println(x.fullName()));


        System.out.println("Students with marks > 40");


        students.stream()
                .filter(x -> x.getMarks()>40)
                .forEach(x -> {
                    System.out.println(x.fullName());
                    System.out.println("Marks: " + x.getMarks());
                });
    }
}