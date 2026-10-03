package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.HospitalDoctorsAndPatients;

import java.util.ArrayList;

class Hospital {

    private String hospitalName;
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;

    Hospital(String hospitalName){
        this.hospitalName = hospitalName;
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
    }

    void addDoctorData(Doctor doctor){
        doctors.add(doctor);
    }

    void addPatientData(Patient patient){
        patients.add(patient);
    }
    void showDoctors() {
        System.out.println("Doctors at " + hospitalName + ":");

        for (Doctor doctor : doctors) {
            System.out.println(
                    doctor.getDoctorName() + " (" + doctor.getDoctorID() + ")"
            );
        }
    }

    void showPatients() {
        System.out.println("Patients at " + hospitalName + ":");

        for (Patient patient : patients) {
            System.out.println(
                    patient.getPatientName() + " (" + patient.getPatientID() + ")"
            );
        }
    }
}
