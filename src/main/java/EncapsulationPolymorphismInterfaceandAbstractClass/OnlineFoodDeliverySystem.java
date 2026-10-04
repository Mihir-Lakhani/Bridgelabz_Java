package EncapsulationPolymorphismInterfaceandAbstractClass;

import java.util.ArrayList;
import java.util.List;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem implements Discountable {
    private final String itemName;
    private final double price;
    private int quantity;

    FoodItem(String itemName, double price, int quantity) {
        if (price < 0 || quantity <= 0) {
            throw new IllegalArgumentException("Price and quantity must be valid");
        }
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.quantity = quantity;
    }

    abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.printf("%s - %.2f each, quantity: %d%n", itemName, price, quantity);
    }
}

class VegItem extends FoodItem {
    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg discount: 10%";
    }
}

class NonVegItem extends FoodItem {
    NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    double calculateTotalPrice() {
        return (getPrice() + 40) * getQuantity(); // 40 packing charge per item
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-veg discount: 5%";
    }
}

public class OnlineFoodDeliverySystem {
    private static void processOrder(List<FoodItem> items) {
        double orderTotal = 0;

        for (FoodItem item : items) {
            item.getItemDetails();
            double itemTotal = item.calculateTotalPrice();
            double discount = item.applyDiscount();
            System.out.println(item.getDiscountDetails());
            System.out.printf("Item total: %.2f, discount: %.2f, payable: %.2f%n%n",
                    itemTotal, discount, itemTotal - discount);
            orderTotal += itemTotal - discount;
        }

        System.out.printf("Order total: %.2f%n", orderTotal);
    }

    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Wrap", 180, 2));
        order.add(new NonVegItem("Chicken Burger", 220, 1));
        processOrder(order);
    }
}
