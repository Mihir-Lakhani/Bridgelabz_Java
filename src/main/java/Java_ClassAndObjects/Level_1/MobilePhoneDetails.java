/*
5. Program to Handle Mobile Phone Details
Problem Statement: Create a MobilePhone class with attributes brand, model, and price.
Add a method to display all the details of the phone.
 */

package Java_ClassAndObjects.Level_1;

class MobilePhone{

    String brand;
    String model;
    int price;

    public void displayDetails(){
        System.out.printf("Brand of the Phone: %s\n", this.brand);
        System.out.printf("Model of the Phone: %s\n", this.model);
        System.out.printf("Price of the Phone: Rs.%d\n", this.price);
    }

    MobilePhone(String brand, String model, int price){
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

}

public class MobilePhoneDetails {
    public static void main(String[] args) {

        MobilePhone m1 = new MobilePhone("Samsung", "Galaxy M14", 14000);
        m1.displayDetails();

    }
}
