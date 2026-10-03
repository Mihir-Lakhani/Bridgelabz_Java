package Java_Inheritance.SelfProblems.HybridInheritance;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


class Vehicle{

    private String name;
    private String noPlate;

    Vehicle(String name, String noPlate){
        this.name = name;
        this.noPlate = noPlate;
    }

    String getName(){
        return name;
    }

    String getNoPlate(){
        return noPlate;
    }

    void Start(){
        System.out.println("Starting the Vehicle");
    }
}

interface Refuelable{

    void Refuel();
}

class ElectricVehicle extends Vehicle{

    ElectricVehicle(String name, String noPlate){
        super(name, noPlate);
    }

    @Override
    public void Start(){
        System.out.println("Starting Electric Vehicle"+getNoPlate());
    }
}

class PetrolVehicle extends Vehicle implements Refuelable{
    PetrolVehicle(String name, String noPlate){
        super(name, noPlate);
    }
    @Override
    public void Start(){
        System.out.println("Starting Petrol Vehicle"+getNoPlate());
    }
    @Override
    public void Refuel(){
        System.out.println("Refueling the Vehicle "+getName()+"("+getNoPlate()+")");
    }
}


public class VehicleManagementSystemWithHybridInheritance {
    public static void main(String[] args) {

        Vehicle[] cars = {
                new ElectricVehicle("Tesla", "RJ03CA3789"),
                new PetrolVehicle("KIA Seltos", "TN09AB3409")
        };

        for (Vehicle car : cars){
            if (car instanceof PetrolVehicle){
                PetrolVehicle something = (PetrolVehicle) car;
                something.Refuel();
            }
            car.Start();
        }

    }
}