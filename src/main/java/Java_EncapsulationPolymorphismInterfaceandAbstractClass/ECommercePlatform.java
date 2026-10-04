package Java_EncapsulationPolymorphismInterfaceandAbstractClass;

import java.util.ArrayList;

abstract class Product implements Taxable{
    private String productId;
    private String name;
    private double price;

    Product(String name, String productId, double price){
        this.name = name;
        this.productId = productId;
        this.price = price;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public String getProductId() { return productId; }

    public void setName(String name) { this.name = name; }

    public void setPrice(double price) { this.price = price; }

    public void setProductId(String productId) { this.productId = productId; }

    abstract void calculateFinalPrice();

    public void displayDetails(){
        System.out.printf("Name: %s\t", name);
        System.out.printf("Id: %s\t", productId);
        System.out.printf("Price: %.2f\t", price);
        System.out.println();
    }

}

interface Taxable{
    double calculateTax();
    void getTaxDetails();
}

class Electronics extends Product implements Taxable{
    final int discount = 5;
    final int tax = 12;

    Electronics(String name, String productId, double price){
        super(name, productId, price);
    }

    @Override
    public double calculateTax(){
        return getPrice() * tax/100;
    }

    @Override
    public void getTaxDetails(){
        System.out.printf("Tax: %d\nTax Add: %.2f\n\n", tax, getPrice() * tax/100);
    }

    @Override
    void calculateFinalPrice() {
        System.out.printf("Final Price: %.2f\n\n",  getPrice() + calculateTax());
        System.out.println("================================================");
    }
}
class Clothing extends Product implements Taxable{
    final int discount = 20;
    final int tax = 6;


    Clothing(String name, String productId, double price){
        super(name, productId, price);
    }

    @Override
    public double calculateTax(){
        return getPrice() * tax/100;
    }

    @Override
    public void getTaxDetails(){
        System.out.printf("Tax: %d\nTax Add: %.2f\n\n", tax, getPrice() * tax/100);
    }

    @Override
    void calculateFinalPrice() {
        System.out.printf("Final Price: %.2f\n\n",  getPrice() + calculateTax());
        System.out.println("================================================");
    }
}
class Groceries extends Product implements Taxable{
    final int discount = 15;
    final int tax = 3;


    Groceries(String name, String productId, double price){
        super(name, productId, price);
    }

    @Override
    public double calculateTax(){
        return getPrice() * tax/100;
    }

    @Override
    public void getTaxDetails(){
        System.out.println();
        System.out.printf("Tax: %d\nTax Add: %.2f\n\n", tax, getPrice() * tax/100);
        System.out.println();
    }

    @Override
    void calculateFinalPrice() {
        System.out.printf("Final Price: %.2f\n\n",  getPrice() + calculateTax());
        System.out.println("================================================");
    }
}
public class ECommercePlatform {
    public static void main(String[] args) {

        Groceries g1 = new Groceries("Dhaniya", "G001", 20);
        Groceries g2 = new Groceries("Atta", "G002", 324);
        Groceries g3 = new Groceries("Pyaaz", "G003", 56);

        Clothing c1 = new Clothing("Jacket", "C001", 2399.99);
        Clothing c2 = new Clothing("T-Shirt", "C002", 299.99);
        Clothing c3 = new Clothing("Shorts", "C003", 599.89);

        Electronics e1 = new Electronics("Mobile", "E001", 14999.99);
        Electronics e2 = new Electronics("Mouse", "E002", 2499.99);
        Electronics e3 = new Electronics("Earbuds", "E003", 11399.99);

        ArrayList<Product> products = new ArrayList<>();
        products.add(g1);
        products.add(g2);
        products.add(g3);
        products.add(c1);
        products.add(c2);
        products.add(c3);
        products.add(e1);
        products.add(e2);
        products.add(e3);

        for(Product product : products){
            product.displayDetails();
            product.getTaxDetails();
            product.calculateFinalPrice();
        }




    }

}