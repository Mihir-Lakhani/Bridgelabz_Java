/*
A program to calculate the total purchase price
using unit price and quantity.
 */

package Java_Programming_Elements.Level_1;
import java.util.Scanner;

public class TotalPurchasePrice {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the unit price: ");
        double unitPrice = sc.nextDouble(); //Taking unit price input

        System.out.println("Enter the quantity: ");
        int quantity = sc.nextInt(); //Taking quantity input

        //Calculate the total purchase price
        double totalPrice = unitPrice * quantity;

        //Print total purchase price
        System.out.printf("The total purchase price is INR %.2f if the quantity is %d and unit price is INR %.2f",
                totalPrice, quantity, unitPrice);
    }
}