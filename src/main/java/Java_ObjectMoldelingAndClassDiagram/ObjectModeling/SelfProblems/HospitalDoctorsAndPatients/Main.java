package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.HospitalDoctorsAndPatients;

public class Main {
    public static void main(String[] args) {

        Hospital h = new Hospital("Apollo");

        Doctor d1 = new Doctor("Dr. A", 101);
        Doctor d2 = new Doctor("Dr. B", 102);

        Patient p1 = new Patient("Mihir", 201);
        Patient p2 = new Patient("Rishika", 202);

        h.addDoctorData(d1);
        h.addDoctorData(d2);

        h.addPatientData(p1);
        h.addPatientData(p2);

        d1.consult(p1);
        d1.consult(p2);

        d2.consult(p1);

        d1.showPatients();
        d2.showPatients();
        p1.showDoctors();
        p2.showDoctors();

        h.showDoctors();
        h.showPatients();
    }
}
