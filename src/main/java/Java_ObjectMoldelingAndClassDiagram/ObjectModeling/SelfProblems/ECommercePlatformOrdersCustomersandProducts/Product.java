package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.SelfProblems.ECommercePlatformOrdersCustomersandProducts;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Product {

    private String productName;
    final private String productId;
    final private double productPrice;
    int itemCount;

    Product(String productName, String productId, double productPrice, int itemCount){
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
        this.itemCount = itemCount;
    }

    String getProductName() {
        return productName;
    }

    String getProductId() {
        return productId;
    }

    double getProductPrice() {
        return productPrice;
    }

    int getItemCount() {
        return itemCount;
    }

}