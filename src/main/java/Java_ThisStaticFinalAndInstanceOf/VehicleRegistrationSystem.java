/*
Sample Program 6: Vehicle Registration System
Create a Vehicle class with the following features:
Static:
A static variable registrationFee common for all vehicles.
A static method updateRegistrationFee() to modify the fee.
This:
Use this to initialize ownerName, vehicleType, and registrationNumber in the constructor.
Final:
Use a final variable registrationNumber to uniquely identify each vehicle.
Instanceof:
Check if an object belongs to the Vehicle class before displaying its registration details.
 */

package Java_ThisStaticFinalAndInstanceOf;

import java.util.Scanner;

class Vehicle{
    static int registrationFee;
    String ownerName;
    String vehicleType;
    final int registrationNumber;

    Vehicle(String ownerName, String vehicleType, int registrationNumber){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(int registrationFee){
        Vehicle.registrationFee = registrationFee;
    }

    void display(){
        System.out.println("Owner name: "+ownerName);
        System.out.println("Type of the Vehicle: "+vehicleType);
        System.out.println("Registration Number: "+registrationNumber);
        System.out.println("Registration Fee: "+registrationFee);
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Set registration fee
        Vehicle.updateRegistrationFee(5000);

        // First vehicle
        Vehicle v1 = new Vehicle("Mihir", "Car", 101);

        if (v1 instanceof Vehicle) {
            v1.display();
        }

        System.out.println("======================");

        // Second vehicle
        Vehicle v2 = new Vehicle("Rahul", "Bike", 102);

        if (v2 instanceof Vehicle) {
            v2.display();
        }

        // Update registration fee for all vehicles
        Vehicle.updateRegistrationFee(6000);

        System.out.println("======================");
        System.out.println("After updating registration fee:");

        if (v1 instanceof Vehicle) {
            v1.display();
        }
    }
}