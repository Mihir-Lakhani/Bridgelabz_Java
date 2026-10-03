/*
Sample Problem 1: Restaurant Management System with Hybrid Inheritance
Description: Model a restaurant system where Person is the superclass and Chef and Waiter are subclasses. Both Chef and Waiter should implement a Worker interface that requires a performDuties() method.
Tasks:
Define a superclass Person with attributes like name and id.
Create an interface Worker with a method performDuties().
Define subclasses Chef and Waiter that inherit from Person and implement the Worker interface, each providing a unique implementation of performDuties().
Goal: Practice hybrid inheritance by combining inheritance and interfaces, giving multiple behaviors to the same objects.
 */

package Java_Inheritance.SelfProblems.HybridInheritance;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Person{

    private String name;
    private int id;

    Person(String name, int id){
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }
}


interface Worker{
    void performDuties();
    String getName();
}


class Chef extends Person implements Worker{

    Chef(String name, int id){
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("I am Cooking...");
    }
}

class Waiter extends Person implements Worker{

    Waiter(String name, int id){
        super(name, id);
    }

    @Override
    public void performDuties(){
        System.out.println("I am Serving...");
    }

}


public class RestaurantManagementSystemWithHybridInheritance {
    public static void main(String[] args) {

        Worker[] workers = {
                new Chef("Mihir", 46),
                new Waiter("Shrey", 48)
        };

        for (Worker worker: workers){
            worker.performDuties();
            System.out.println(worker.getName());
        }
    }
}