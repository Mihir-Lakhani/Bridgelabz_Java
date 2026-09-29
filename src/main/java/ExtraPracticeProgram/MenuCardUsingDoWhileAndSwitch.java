package ExtraPracticeProgram;

import java.util.Arrays;
import java.util.Scanner;

public class MenuCardUsingDoWhileAndSwitch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = 0;
        String[] cart = new String[count];
        int id;
        do{
            System.out.println("This is the menu card, enter item number to add the item in the cart");
            System.out.println("1. Pizza");
            System.out.println("2. Sandwich");
            System.out.println("3. Burger");
            System.out.println("0. End");
            id = sc.nextInt();

            switch (id){
                case 1:
                    System.out.println("Added Pizza");
                    count++;
                    cart = Arrays.copyOf(cart, count);
                    cart[count-1] = "Pizza";
                    break;
                case 2:
                    System.out.println("Added Burger");
                    count++;
                    cart = Arrays.copyOf(cart, count);
                    cart[count-1] = "Burger";
                    break;
                case 3:
                    System.out.println("Added Sandwich");
                    count++;
                    cart = Arrays.copyOf(cart, count);
                    cart[count-1] = "Sandwich";
                    break;
                case 0:
                    System.out.println("Moving to Cart");
                    break;
                default:
                    System.out.println("Enter correct value");
                    break;
            }

        }while(id!=0);

        System.out.println("YOUR CART");
        System.out.printf("%s", Arrays.toString(cart));

    }
}