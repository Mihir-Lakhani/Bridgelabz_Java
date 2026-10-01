/*
Sample Program 7: Hospital Management System
Create a Patient class with the following features:
Static:
A static variable hospitalName shared among all patients.
A static method getTotalPatients() to count the total patients admitted.
This:
Use this to initialize name, age, and ailment in the constructor.
Final:
Use a final variable patientID to uniquely identify each patient.
Instanceof:
Check if an object is an instance of the Patient class before displaying its details.
 */

package Java_ThisStaticFinalAndInstanceOf;

import java.util.Scanner;


class Patient {

    static String hospitalName;
    static int totalPatients;

    String ailment;
    String name;
    int age;

    final int patientID;


    Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;

        totalPatients++;
    }


    Patient() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Patient ID: ");
        this.patientID = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter Patient Name: ");
        this.name = sc.nextLine();

        System.out.println("Enter Patient Age: ");
        this.age = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter Patient Ailment: ");
        this.ailment = sc.nextLine();

        totalPatients++;
    }


    static int getTotalPatients() {
        return totalPatients;
    }


    void display() {
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Patient Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }
}


public class HospitalManagementSystem {

    public static void main(String[] args) {

        Patient.hospitalName = "Apollo Hospital";

        Patient p1 = new Patient(
                101,
                "Mihir",
                20,
                "Fever"
        );

        if (p1 instanceof Patient) {
            p1.display();
        }


        System.out.println("======================");


        Patient p2 = new Patient();

        if (p2 instanceof Patient) {
            p2.display();
        }


        System.out.println("======================");

        System.out.println(
                "Total Patients: " + Patient.getTotalPatients()
        );
    }
}