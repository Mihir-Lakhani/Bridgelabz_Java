/*
A program to take Student Fee and University Discount as input
and calculate the final discounted fee.
 */

package Java_Programming_Elements.Level_1;
import java.util.Scanner;

public class StudentDiscountInput {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter the University fee: ");
        double fee = sc.nextDouble(); //Taking fee input

        System.out.println("Enter the discount percentage: ");
        double discountPercent = sc.nextDouble(); //Taking discount input

        //Calculate the discount amount
        double discount = (fee * discountPercent) / 100.0;

        //Calculate final discounted fee
        double discountedFee = fee - discount;

        //Print the calculated values
        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f",
                discount, discountedFee);
    }
}