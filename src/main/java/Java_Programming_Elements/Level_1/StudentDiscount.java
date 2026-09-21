/*
Find out the Discounted amount and the discounted fees if given the principal fees and the discount percentage
 */

public class StudentDiscount {
    public static void main(String[] args){

        //The fee Given is stored in the int variable
        int fee = 125000;

        // create the variable that store the percentage discount
        int discount_in_percent = 10;

        // Calculate the discount value and tore it in the double var
        double discount_got = (fee * discount_in_percent)/100.0;

        //Calculate the Discounted fee and store it in the double variable
        double discounted_fee = fee - discount_got;

        //Print the values we calculated
        System.out.printf("Thee Discount amount is INR%.2f and the final discounted fee is %.2f", discount_got, discounted_fee);
    }
}
