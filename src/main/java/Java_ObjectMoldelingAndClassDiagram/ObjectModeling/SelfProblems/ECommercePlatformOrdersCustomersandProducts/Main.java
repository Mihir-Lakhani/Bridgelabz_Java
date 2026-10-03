package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.ECommercePlatformOrdersCustomersandProducts;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Customer c1 = new Customer("cart1");
        c1.addCart("cart2");


        Product p1 = new Product("Headphone", "HP001", 1699.99, 2);
        Product p2 = new Product("Sunscreen", "SC001", 149.99, 1);
        Product p3 = new Product("Mouse", "MS001", 799.00, 1);
        Product p4 = new Product("Notebook", "NB001", 89.50, 3);
        Product p5 = new Product("Water Bottle", "WB001", 349.00, 2);
        Product p6 = new Product("Keyboard", "KB001", 1299.00, 1);
        Product p7 = new Product("Pen", "PN001", 20.00, 5);
        Product p8 = new Product("Backpack", "BP001", 1999.00, 1);
        Product p9 = new Product("Phone Case", "PC001", 299.00, 2);
        Product p10 = new Product("Desk Lamp", "DL001", 899.00, 1);


        Order o1 = c1.getOrder(0);
        Order o2 = c1.getOrder(1);

        c1.addProduct(o1, p1);
        c1.addProduct(o1, p2);
        c1.addProduct(o1, p3);
        c1.addProduct(o1, p4);
        c1.addProduct(o1, p5);
        c1.addProduct(o1, p6);
        c1.addProduct(o2, p7);
        c1.addProduct(o2, p8);
        c1.addProduct(o2, p9);
        c1.addProduct(o2, p10);

        c1.placeOrder();

    }
}