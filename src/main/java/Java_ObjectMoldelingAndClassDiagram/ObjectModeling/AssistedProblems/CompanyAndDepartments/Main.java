package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.AssistedProblems.CompanyAndDepartments;

public class Main {
    public static void main(String[] args) {
        Company c1 = new Company("Tech Solutions");
        c1.addDepartment("Development");
        c1.addDepartment("HR");

        c1.addEmployee("Development", "Mihir", "Java Developer");
        c1.addEmployee("Development", "Shrey", "Tester");
        c1.addEmployee("HR", "Rishika", "HR Manager");

        Company c2 = new Company("Bright Apps");
        c2.addDepartment("Support");
        c2.addEmployee("Support", "Ananya", "Support Engineer");

        System.out.println("Before deletion:");
        c1.displayDetails();

        c1.deleteCompany();

        System.out.println("\nAfter deletion:");
        c1.displayDetails();

        System.out.println("\nThe other company still has its own departments and employees:");
        c2.displayDetails();
    }
}
