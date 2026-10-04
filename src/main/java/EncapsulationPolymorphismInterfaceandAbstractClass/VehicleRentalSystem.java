package EncapsulationPolymorphismInterfaceandAbstractClass;

import java.util.ArrayList;
import java.util.List;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    abstract double calculateRentalCost(int days);

    @Override
    public String getInsuranceDetails() {
        String lastFour = insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
        return "Insurance policy: ****" + lastFour;
    }

    public void displayDetails() {
        System.out.println("Vehicle: " + type + " (" + vehicleNumber + ")");
        System.out.printf("Daily rental rate: %.2f%n", rentalRate);
    }
}

class Car extends Vehicle {
    Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 300;
    }
}

class Bike extends Vehicle {
    Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
    }

    @Override
    double calculateRentalCost(int days) {
        double cost = getRentalRate() * days;
        return days >= 7 ? cost * 0.90 : cost;
    }

    @Override
    public double calculateInsurance() {
        return 100;
    }
}

class Truck extends Vehicle {
    Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    @Override
    double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; // One-time handling charge
    }

    @Override
    public double calculateInsurance() {
        return 500;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("CAR101", 2000, "POL12345678"));
        vehicles.add(new Bike("BIKE102", 500, "POL87654321"));
        vehicles.add(new Truck("TRUCK103", 3500, "POL11223344"));

        int days = 7;
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            System.out.println(vehicle.getInsuranceDetails());

            double rentalCost = vehicle.calculateRentalCost(days);
            double insuranceCost = vehicle.calculateInsurance();
            System.out.printf("Rental cost for %d days: %.2f%n", days, rentalCost);
            System.out.printf("Insurance cost: %.2f%n", insuranceCost);
            System.out.printf("Total cost: %.2f%n%n", rentalCost + insuranceCost);
        }
    }
}
