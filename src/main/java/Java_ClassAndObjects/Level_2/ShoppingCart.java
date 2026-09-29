/*
5. Program to Simulate a Shopping Cart
Problem Statement: Create a CartItem class with attributes itemName, price, and quantity.
Add methods to add an item, remove an item, and display the total cost.
 */

package Java_ClassAndObjects.Level_2;

class CartItem{

    String itemName;
    int price;
    int quantity;

    CartItem(String itemName, int price){
        this.itemName = itemName;
        this.price = price;
        this.quantity = 0;
    }

    public void addItem(int quantity){
        if (quantity <= 0){
            System.out.println("Enter a positive quantity.");
            return;
        }
        this.quantity += quantity;
        System.out.println(quantity + " " + itemName + " added to cart.");
    }

    public void removeItem(int quantity){
        if (quantity <= 0){
            System.out.println("Enter a positive quantity.");
            return;
        }
        if (quantity > this.quantity){
            System.out.println("Not enough items in the cart.");
            return;
        }
        this.quantity -= quantity;
        System.out.println(quantity + " " + itemName + " removed from cart.");
    }

    public void displayTotalCost(){
        System.out.printf("Item Name: %s\n", this.itemName);
        System.out.printf("Quantity: %d\n", this.quantity);
        System.out.printf("Total Cost: Rs.%d\n", this.price * this.quantity);
    }

}

public class ShoppingCart {
    public static void main(String[] args) {

        CartItem c1 = new CartItem("Notebook", 50);
        c1.addItem(3);
        c1.displayTotalCost();
        c1.removeItem(1);
        c1.displayTotalCost();

    }
}
