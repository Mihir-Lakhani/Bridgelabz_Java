/*
A program to divide N number of chocolates
among M number of children.
 */

package Java_Programming_Elements.Level_2;
import java.util.Scanner;

public class ChocolateDistribution {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); //Initialize scanner as sc

        System.out.println("Enter number of chocolates: ");
        int numberOfChocolates = sc.nextInt();

        System.out.println("Enter number of children: ");
        int numberOfChildren = sc.nextInt();

        //Calculate chocolates received by each child
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;

        //Calculate remaining chocolates
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        //Print the results
        System.out.printf("The number of chocolates each child gets is %d and the number of remaining chocolates are %d",
                chocolatesPerChild, remainingChocolates);
    }
}