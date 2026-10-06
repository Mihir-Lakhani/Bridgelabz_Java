package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.UniversityWithFacultyAndDepartments;

public class Main {
    public static void main(String[] args) {


        Faculty f1 = new Faculty("Mihir");
        System.out.println("Added Faculty: "+f1.getFacultyName());

        Faculty f2 = new Faculty("Rishika");
        System.out.println("Added Faculty: "+f2.getFacultyName());

        Faculty f3 = new Faculty("Shrey");
        System.out.println("Added Faculty: "+f3.getFacultyName());

        University u = new University("SRM-ktr");

        Department cse = u.addDepartment("CSE"); //new Dep
        Department ece = u.addDepartment("ECE");

        cse.addFaculty(f1, u);
        ece.addFaculty(f2, u);
        ece.addFaculty(f3, u);

        cse.DisplayFromDepartment();
        ece.DisplayFromDepartment();
        u.DisplayAll();

    }
}