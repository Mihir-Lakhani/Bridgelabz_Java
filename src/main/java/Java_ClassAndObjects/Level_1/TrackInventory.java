/*
4. Program to Track Inventory of Items
Problem Statement: Create an Item class with attributes itemCode, itemName, and price.
Add a method to display item details and calculate the total cost for a given quantity.
 */

package Java_ClassAndObjects.Level_1;

import java.util.Scanner;


class Item{

    String itemCode;
    String itemName;
    int price;

    public void displayDetails(){
        System.out.printf("Code of the Item: %s\n", this.itemCode);
        System.out.printf("Name of the Item: %s\n", this.itemName);
        System.out.printf("Price of the Item: Rs.%s\n", this.price);
    }

    Item(String itemCode, String itemName, int price){
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public int TotalCost(int quantity){
        return this.price * quantity;
    }

}

public class TrackInventory {
    public static void main(String[] args) {

        Item i1 = new Item("AB123", "Gloves", 140);
        i1.displayDetails();

    }
}