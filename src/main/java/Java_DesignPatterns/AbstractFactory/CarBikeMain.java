package Java_DesignPatterns.AbstractFactory;

import java.util.*;

interface Car{
    void driveCar();
}

class Sedan implements Car{
    @Override
    public void driveCar() {
        System.out.println("Driving " + this.getClass().getSimpleName());
    }
}

class SUV implements Car{
    @Override
    public void driveCar() {
        System.out.println("Driving " + this.getClass().getSimpleName());
    }
}

interface Bike{
    void driveBike();
}

class SportsBike implements Bike{
    @Override
    public void driveBike() {
        System.out.println("Riding " + this.getClass().getSimpleName());
    }
}

class NormalBike implements Bike{
    @Override
    public void driveBike() {
        System.out.println("Riding " + this.getClass().getSimpleName());
    }
}

abstract class VehicleFactory {
    public abstract Car createCar();
    public abstract Bike createBike();
}

class StandardVehicleFactory extends VehicleFactory {
    public Car createCar() {
        return new Sedan();
    }

    public Bike createBike() {
        return new NormalBike();
    }
}

class SportVehicleFactory extends VehicleFactory {
    public Car createCar() {
        return new SUV();
    }

    public Bike createBike() {
        return new SportsBike();
    }
}

public class CarBikeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Standard vehicles");
        System.out.println("2. Sport vehicles");
        int choice = sc.nextInt();

        VehicleFactory factory;

        if (choice == 1) {
            factory = new StandardVehicleFactory();
        } else if (choice == 2) {
            factory = new SportVehicleFactory();
        } else {
            System.out.println("Invalid choice");
            return;
        }

        Car car = factory.createCar();
        Bike bike = factory.createBike();

        car.driveCar();
        bike.driveBike();
    }
}