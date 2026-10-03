package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.ECommercePlatformOrdersCustomersandProducts;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Order {

    int totalProducts;
    double totalprice;
    private String orderName;

    ArrayList<Product> products;

    Order(String orderName){
        products = new ArrayList<>();
        this.orderName = orderName;
    }

    void addProd(Product product){
        products.add(product);
        totalprice += product.getProductPrice()*product.itemCount;
        totalProducts += product.itemCount;
    }

    void listProducts(){
        System.out.println("====================================");
        System.out.println("Products in order "+this.orderName+" :");
        for (Product product: products){
            System.out.println("Product Name: "+ product.getProductName());
            System.out.println("Product ID: "+ product.getProductId());
            System.out.println("Product Price: "+ product.getProductPrice());
            System.out.println("Product Count: "+ product.getItemCount());
            System.out.println("Total Price: "+ String.format("%.2f",product.getItemCount()*product.getProductPrice()));
            System.out.println("====================================");
        }
        System.out.println("====================================");
    }
}