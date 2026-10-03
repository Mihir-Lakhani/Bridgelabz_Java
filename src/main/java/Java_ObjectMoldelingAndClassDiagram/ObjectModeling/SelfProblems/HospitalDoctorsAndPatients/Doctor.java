package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.HospitalDoctorsAndPatients;

import java.util.ArrayList;

class Doctor {

    private String doctorName;
    private int doctorID;
    private ArrayList<Patient> patients;

    Doctor(String doctorName, int doctorID){
        this.doctorName = doctorName;
        this.doctorID = doctorID;
        patients = new ArrayList<>();
    }

    void consult(Patient patient){
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
        System.out.println(doctorName + " is consulting " + patient.getPatientName());
    }

    String getDoctorName(){
        return doctorName;
    }
    int getDoctorID(){
        return doctorID;
    }

    void showPatients(){
        System.out.println("Patients of " + doctorName + " (" + doctorID + "):");
        for (Patient p: patients){
            System.out.println(p.getPatientName() + " (" + p.getPatientID() + ")");
        }
    }

}
