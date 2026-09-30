package Java_ConstructorsInstancesAndAccessModifiers.InstancesVsClassVariablesAndMethods;

import java.util.Scanner;

class Product{
    String productName;
    int price;
    static int totalProducts;

    Product(String productName, int price){
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    public void DisplayProductDetails(){
        System.out.printf("Name of the product: %s\n", productName);
        System.out.printf("Price: %d\n", price);
    }

    public static void DisplayTotalProducts(){
        System.out.printf("Total Products: %d: ", totalProducts);
    }

}

public class ProductInventory {

    public static void main(String[] args) {

        Product p1 = new Product("HeadPhones", 2390);
        Product p2 = new Product("Mouse", 1240);

        p1.DisplayProductDetails();
        p2.DisplayProductDetails();
        Product.DisplayTotalProducts();

    }
}