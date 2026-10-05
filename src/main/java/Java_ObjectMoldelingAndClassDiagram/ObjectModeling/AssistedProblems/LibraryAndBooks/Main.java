package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.AssistedProblems.LibraryAndBooks;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Books exist independently of libraries
        Book b1 = new Book("James Clear", "Atomic Habits");
        Book b2 = new Book("J.K. Rowling", "Harry Potter");
        Book b3 = new Book("Paulo Coelho", "The Alchemist");

        Library l1 = new Library("City Library");
        Library l2 = new Library("College Library");

        l1.addBook(b1);
        l1.addBook(b2);

        l2.addBook(b2);
        l2.addBook(b3);

        System.out.println(l1.getName() + ":");
        l1.displayAllBooks();

        System.out.println();

        System.out.println(l2.getName() + ":");
        l2.displayAllBooks();

        // A book can also be accessed directly
        System.out.println("\nIndependent book: " + b1.getTitle());
    }
}