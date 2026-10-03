package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.HospitalDoctorsAndPatients;

import java.util.ArrayList;

class Patient {

    private String patientName;
    private int patientID;
    private ArrayList<Doctor> doctors;

    Patient(String patientName, int patientID){
        this.patientName = patientName;
        this.patientID = patientID;
        doctors = new ArrayList<>();
    }

    void addDoctor(Doctor doctor){
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    String getPatientName(){
        return patientName;
    }
    int getPatientID(){
        return patientID;
    }

    void showDoctors(){
        System.out.println("Doctors of " + patientName + " (" + patientID + "):");
        for (Doctor doctor: doctors){
            System.out.println(doctor.getDoctorName() + " (" + doctor.getDoctorID() + ")");
        }
    }
}
