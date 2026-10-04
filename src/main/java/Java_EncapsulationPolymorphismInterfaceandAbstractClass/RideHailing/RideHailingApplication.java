package Java_EncapsulationPolymorphismInterfaceandAbstractClass.RideHailing;

import java.util.ArrayList;
import java.util.List;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

abstract class Vehicle implements GPS {
    private final String vehicleId;
    private final String driverName;
    private final String type;
    private final double ratePerKm;
    private String currentLocation = "Not updated";

    Vehicle(String vehicleId, String driverName, String type, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.type = type;
        this.ratePerKm = ratePerKm;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println(type + " " + vehicleId + " - Driver: " + driverName);
        System.out.printf("Rate per km: %.2f%n", ratePerKm);
        System.out.println("Current location: " + getCurrentLocation());
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        if (location == null || location.isBlank()) {
            System.out.println("Location cannot be empty.");
            return;
        }
        currentLocation = location;
    }
}

class Car extends Vehicle {
    Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, "Car", ratePerKm);
    }

    @Override
    double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; // Booking charge
    }
}

class Bike extends Vehicle {
    Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, "Bike", ratePerKm);
    }

    @Override
    double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

class Auto extends Vehicle {
    Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, "Auto", ratePerKm);
    }

    @Override
    double calculateFare(double distance) {
        return getRatePerKm() * distance + 20; // Starting charge
    }
}

public class RideHailingApplication {
    private static void showFare(Vehicle vehicle, double distance) {
        vehicle.getVehicleDetails();
        System.out.printf("Fare for %.1f km: %.2f%n%n", distance,
                vehicle.calculateFare(distance));
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("C101", "Aman", 18));
        vehicles.add(new Bike("B102", "Neha", 8));
        vehicles.add(new Auto("A103", "Ravi", 12));

        vehicles.get(0).updateLocation("City Centre");
        vehicles.get(1).updateLocation("Railway Station");
        vehicles.get(2).updateLocation("Market Road");

        for (Vehicle vehicle : vehicles) {
            showFare(vehicle, 10);
        }
    }
}
