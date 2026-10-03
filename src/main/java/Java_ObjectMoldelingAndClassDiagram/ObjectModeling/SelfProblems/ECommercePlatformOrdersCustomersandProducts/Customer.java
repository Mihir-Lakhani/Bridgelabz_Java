package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.ECommercePlatformOrdersCustomersandProducts;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Customer {

    private String name;
    private long Phone;
    private ArrayList<Order> orders = new ArrayList<>();

    Customer(String orderName){
        orders.add(new Order(orderName));
    }

    Order getOrder(int index) {
        return orders.get(index);
    }

    void addCart(String orderName){
        orders.add(new Order(orderName));
    }

    void addProduct(Order order, Product product) {
        order.addProd(product);
    }


    void placeOrder(){
        //list all the products
        System.out.println("====================================");
        System.out.println("Order Details: ");
        for (Order order: orders){
            order.listProducts();
            System.out.println("Total items in the Cart: "+order.totalProducts);
            System.out.println("Total Cart Value: "+order.totalprice);
        }
        System.out.println("====================================");
        System.out.println("====================================");

    }
}