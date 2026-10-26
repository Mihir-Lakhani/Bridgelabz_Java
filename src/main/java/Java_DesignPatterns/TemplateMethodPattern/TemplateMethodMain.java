package Java_DesignPatterns.TemplateMethodPattern;

abstract class OrderProcess {

    public final void processOrder() {
        verifyOrder();
        makePayment();
        deliverOrder();
        System.out.println("Order complete.\n");
    }

    private void verifyOrder() {
        System.out.println("Verifying the order");
    }

    protected abstract void makePayment();

    protected abstract void deliverOrder();
}

class HomeDeliveryOrder extends OrderProcess {
    @Override
    protected void makePayment() {
        System.out.println("Payment received for home delivery");
    }

    @Override
    protected void deliverOrder() {
        System.out.println("Delivering order to the customer's home");
    }
}

class StorePickupOrder extends OrderProcess {
    @Override
    protected void makePayment() {
        System.out.println("Payment received for store pickup");
    }

    @Override
    protected void deliverOrder() {
        System.out.println("Order is ready for pickup at the store");
    }
}

public class TemplateMethodMain {
    public static void main(String[] args) {
        OrderProcess homeOrder = new HomeDeliveryOrder();
        homeOrder.processOrder();

        OrderProcess pickupOrder = new StorePickupOrder();
        pickupOrder.processOrder();
    }
}
