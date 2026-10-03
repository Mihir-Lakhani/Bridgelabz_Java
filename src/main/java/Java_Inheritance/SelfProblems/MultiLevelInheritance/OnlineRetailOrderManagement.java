/*
Program 1: Online Retail Order Management (Multilevel Inheritance)
Order -> ShippedOrder -> DeliveredOrder
Each level adds information and reports its current status.
 */

package Java_Inheritance.SelfProblems.MultiLevelInheritance;

class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Placed";
    }

    void displayDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Shipped";
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Delivered";
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        Order[] orders = {
                new Order("ORD101", "2026-10-01"),
                new ShippedOrder("ORD102", "2026-10-01", "TRK102"),
                new DeliveredOrder("ORD103", "2026-09-28", "TRK103", "2026-10-02")
        };

        for (Order order : orders) {
            order.displayDetails();
            System.out.println("Status: " + order.getOrderStatus());
            System.out.println();
        }
    }
}
