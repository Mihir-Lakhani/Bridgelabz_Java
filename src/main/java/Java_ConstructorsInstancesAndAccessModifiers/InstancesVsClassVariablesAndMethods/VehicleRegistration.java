/*
3. Vehicle Registration
Create a Vehicle class with ownerName and vehicleType as instance variables,
and registrationFee as a class variable.
 */

package Java_ConstructorsInstancesAndAccessModifiers.InstancesVsClassVariablesAndMethods;

class Vehicle{
    String ownerName;
    String vehicleType;
    static int registrationFee = 1000;

    Vehicle(String ownerName, String vehicleType){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails(){
        System.out.printf("Owner Name: %s\n", ownerName);
        System.out.printf("Vehicle Type: %s\n", vehicleType);
        System.out.printf("Registration Fee: Rs.%d\n", registrationFee);
    }

    public static void updateRegistrationFee(int newFee){
        registrationFee = newFee;
    }
}

public class VehicleRegistration {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Mihir", "Bike");
        Vehicle v2 = new Vehicle("Riya", "Car");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(1500);
        System.out.println("After updating the registration fee:");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
