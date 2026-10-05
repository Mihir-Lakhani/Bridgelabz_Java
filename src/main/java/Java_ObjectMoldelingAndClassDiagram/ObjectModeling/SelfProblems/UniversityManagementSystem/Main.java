package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.UniversityManagementSystem;

public class Main {
    public static void main(String[] args) {
        Student mihir = new Student("Mihir", "S101");
        Student rishika = new Student("Rishika", "S102");
        Student aarav = new Student("Aarav", "S103");
        Student diya = new Student("Diya", "S104");
        Student kabir = new Student("Kabir", "S105");
        Student ananya = new Student("Ananya", "S106");
        Student ishaan = new Student("Ishaan", "S107");
        Student meera = new Student("Meera", "S108");
        Student neha = new Student("Neha", "S109");
        Student aditya = new Student("Aditya", "S110");
        Student sana = new Student("Sana", "S111");
        Student arjun = new Student("Arjun", "S112");

        Professor javaProfessor = new Professor("Dr. Sharma", "P101");
        Professor mathsProfessor = new Professor("Dr. Mehta", "P102");

        Course java = new Course("Java");
        Course databases = new Course("Databases");
        Course maths = new Course("Mathematics");
        Course physics = new Course("Physics");
        Course dataStructures = new Course("Data Structures");

        java.addProfessor(javaProfessor);
        javaProfessor.teachCourse(databases);
        maths.addProfessor(mathsProfessor);
        mathsProfessor.teachCourse(physics);
        dataStructures.addProfessor(javaProfessor);

        mihir.enrollCourse(java);
        databases.addStudent(mihir);
        rishika.enrollCourse(java);
        maths.addStudent(rishika);
        aarav.enrollCourse(java);
        java.addStudent(diya);
        diya.enrollCourse(physics);
        kabir.enrollCourse(databases);
        databases.addStudent(ananya);
        ananya.enrollCourse(dataStructures);
        ishaan.enrollCourse(maths);
        maths.addStudent(meera);
        neha.enrollCourse(physics);
        physics.addStudent(aditya);
        sana.enrollCourse(dataStructures);
        dataStructures.addStudent(arjun);

        System.out.println("\nUniversity course details:");
        Student[] students = {mihir, rishika, aarav, diya, kabir, ananya,
                ishaan, meera, neha, aditya, sana, arjun};
        Course[] courses = {java, databases, maths, physics, dataStructures};
        System.out.println("Total students: " + students.length);
        System.out.println("Total courses: " + courses.length);
        for (Course course : courses) {
            System.out.println("Course: " + course.getCourseName());
            System.out.println("Professor: " + course.getProfessor().getProfessorName());
            System.out.println("Students:");
            for (Student student : course.students) {
                System.out.println("- " + student.getStudentName() + " (" + student.getStudentid() + ")");
            }
            System.out.println();
        }
    }
}
