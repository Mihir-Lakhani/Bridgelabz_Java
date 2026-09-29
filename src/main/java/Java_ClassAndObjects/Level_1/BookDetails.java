/*
3. Program to Handle Book Details
Problem Statement: Write a program to create a Book class with attributes title, author, and price.
Add a method to display the book details.

 */

package Java_ClassAndObjects.Level_1;

import java.util.Scanner;


class Books{

    String title;
    String author;
    int price;

    public void displayDetails(){
        System.out.printf("Title of the Book: %s\n", this.title);
        System.out.printf("Author of the Book: %s\n", this.author);
        System.out.printf("Price of the Book: Rs.%s\n", this.price);
    }

    Books(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

}

public class BookDetails {
    public static void main(String[] args) {

    Books b1 = new Books("Harry Potter", "J. K. Rowling", 2140);
    b1.displayDetails();

    }
}