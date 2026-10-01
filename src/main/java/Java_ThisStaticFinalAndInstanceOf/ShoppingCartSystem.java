/*
Sample Program 4: Shopping Cart System
Create a Product class to manage shopping cart items with the following features:
Static:
A static variable discount shared by all products.
A static method updateDiscount() to modify the discount percentage.
This:
Use this to initialize productName, price, and quantity in the constructor.
Final:
Use a final variable productID to ensure each product has a unique identifier that cannot be changed.
Instanceof:
Validate whether an object is an instance of the Product class before processing its details.
 */

package Java_ThisStaticFinalAndInstanceOf;

import java.util.Scanner;

class ShoppingCart{
    static int discount;
    String productName;
    double price;
    int quantity;
    final int productID;


    ShoppingCart(int productID, String productName, double price, int quantity){
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    Scanner sc = new Scanner(System.in);
    ShoppingCart(String productName, double price, int quantity){
        System.out.println("Enter the Product ID: ");
        this.productID = sc.nextInt();
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void processProduct(Object obj) {

        if (obj instanceof ShoppingCart) {
            ShoppingCart p = (ShoppingCart) obj;

            System.out.println("Product Name: " + p.productName);
            System.out.println("Price: " + p.price);
            System.out.println("Quantity: " + p.quantity);
            System.out.println("Discount: " + discount);
            System.out.println("Price after discount of " + discount + " is " + String.format("%.2f",(1 - discount/100.0)*p.price));
        }
    }


    public static void updateDiscount(int discount){
        ShoppingCart.discount = discount;
    }


}

public class ShoppingCartSystem {
    public static void main(String[] args) {

        ShoppingCart.updateDiscount(20);
        ShoppingCart cart1 = new ShoppingCart("Headphones", 2349.39, 2);
        ShoppingCart.processProduct(cart1);
    }
}