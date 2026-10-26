package Java_DesignPatterns.StrategyPattern;

import java.util.Scanner;

interface PaymentStrategy {
    void pay(double amount);
}

class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using cash.");
    }
}

class CardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using card.");
    }
}

class UPIPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Choose a payment method first.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

public class StrategyPatternMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext paymentContext = new PaymentContext();

        System.out.println("Choose payment method: 1. Cash  2. Card  3. UPI");
        int choice = scanner.nextInt();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        if (choice == 1) {
            paymentContext.setPaymentStrategy(new CashPayment());
        } else if (choice == 2) {
            paymentContext.setPaymentStrategy(new CardPayment());
        } else if (choice == 3) {
            paymentContext.setPaymentStrategy(new UPIPayment());
        } else {
            System.out.println("Invalid payment choice.");
            scanner.close();
            return;
        }

        paymentContext.makePayment(amount);
        scanner.close();
    }
}
