package Java_Collections.PracticeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Syllabus practical: natural ordering and alternative sorting of custom objects.
public class SortCustomObjects {
    static class Student implements Comparable<Student> {
        final int id;
        final String name;
        final int score;

        Student(int id, String name, int score) {
            this.id = id;
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Student other) { return Integer.compare(id, other.id); }

        @Override
        public String toString() { return id + ":" + name + ":" + score; }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(new Student(3, "Shrey", 90),
                new Student(1, "Mihir", 85), new Student(2, "Asha", 90)));
        Collections.sort(students);
        System.out.println("By ID: " + students);
        students.sort(Comparator.comparingInt((Student s) -> s.score).reversed()
                .thenComparing(s -> s.name).thenComparingInt(s -> s.id));
        System.out.println("By score descending, then name: " + students);
    }
}
