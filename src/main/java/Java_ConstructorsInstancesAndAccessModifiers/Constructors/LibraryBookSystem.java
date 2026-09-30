/*
5. Library Book System
Problem Statement: Create a Book class with attributes title, author, price, and availability.
Implement a method to borrow a book.
*/

package Java_ConstructorsInstancesAndAccessModifiers.Constructors;

class Book {

    private String title;
    private String author;
    private double price;
    private boolean availability;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true;
    }

    public void borrowBook() {

        if (availability) {
            availability = false;
            System.out.println(title + " borrowed successfully.");
        } else {
            System.out.println(title + " is currently unavailable.");
        }
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Available: " + availability);
    }
}

public class LibraryBookSystem {

    public static void main(String[] args) {

        Book b1 = new Book("Atomic Habits", "James Clear", 499);

        b1.display();

        System.out.println();

        b1.borrowBook();

        System.out.println();

        b1.display();

        // Trying to borrow the same book again
        b1.borrowBook();
    }
}