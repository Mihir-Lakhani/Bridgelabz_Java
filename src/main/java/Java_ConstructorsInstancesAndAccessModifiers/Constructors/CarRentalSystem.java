/*
6. Car Rental System
Problem Statement: Create a CarRental class with attributes customerName, carModel,
and rentalDays. Add constructors to initialize the rental details and calculate total cost.
*/

package Java_ConstructorsInstancesAndAccessModifiers.Constructors;

class CarRental {

    private String customerName;
    private String carModel;
    private int rentalDays;

    private final double RENT_PER_DAY = 1500.0;

    // Default constructor
    CarRental() {
        this("Unknown", "Unknown", 1);
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * RENT_PER_DAY;
    }

    public void display() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: Rs. " + calculateTotalCost());
    }
}

public class CarRentalSystem {

    public static void main(String[] args) {

        CarRental c1 = new CarRental("Mihir", "Hyundai Creta", 5);

        c1.display();
    }
}