package EncapsulationPolymorphismInterfaceandAbstractClass;

import java.util.ArrayList;
import java.util.List;

interface MedicalRecord {
    void addRecord(String record, String accessCode);
    void viewRecords(String accessCode);
}

abstract class Patient implements MedicalRecord {
    private final String patientId;
    private final String name;
    private final int age;
    private final String diagnosis;
    private final String accessCode;
    private final List<String> medicalHistory = new ArrayList<>();

    Patient(String patientId, String name, int age, String diagnosis, String accessCode) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.accessCode = accessCode;
    }

    abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }

    @Override
    public void addRecord(String record, String accessCode) {
        if (!this.accessCode.equals(accessCode)) {
            System.out.println("Access denied: record was not added.");
            return;
        }
        medicalHistory.add(record);
    }

    @Override
    public void viewRecords(String accessCode) {
        if (!this.accessCode.equals(accessCode)) {
            System.out.println("Access denied: medical records are private.");
            return;
        }
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Medical history: " + medicalHistory);
    }
}

class InPatient extends Patient {
    private final int daysAdmitted;
    private final double dailyRoomCharge;
    private final double treatmentCharge;

    InPatient(String patientId, String name, int age, String diagnosis, String accessCode,
              int daysAdmitted, double dailyRoomCharge, double treatmentCharge) {
        super(patientId, name, age, diagnosis, accessCode);
        this.daysAdmitted = daysAdmitted;
        this.dailyRoomCharge = dailyRoomCharge;
        this.treatmentCharge = treatmentCharge;
    }

    @Override
    double calculateBill() {
        return daysAdmitted * dailyRoomCharge + treatmentCharge;
    }
}

class OutPatient extends Patient {
    private final double consultationFee;
    private final double testCharge;

    OutPatient(String patientId, String name, int age, String diagnosis, String accessCode,
               double consultationFee, double testCharge) {
        super(patientId, name, age, diagnosis, accessCode);
        this.consultationFee = consultationFee;
        this.testCharge = testCharge;
    }

    @Override
    double calculateBill() {
        return consultationFee + testCharge;
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        String staffCode = "staff123";
        List<Patient> patients = new ArrayList<>();
        patients.add(new InPatient("P101", "Mihir", 26, "Fracture", staffCode,
                3, 2000, 5000));
        patients.add(new OutPatient("P102", "Rishika", 25, "Fever", staffCode,
                800, 500));

        patients.get(0).addRecord("X-ray completed", staffCode);
        patients.get(1).addRecord("Blood test completed", staffCode);

        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.printf("Bill: %.2f%n", patient.calculateBill());
            patient.viewRecords(staffCode);
            System.out.println();
        }

        patients.get(0).viewRecords("guest"); // Shows that records need the access code
    }
}
