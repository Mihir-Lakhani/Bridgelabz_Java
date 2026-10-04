package EncapsulationPolymorphismInterfaceandAbstractClass;

import java.util.ArrayList;
import java.util.List;

interface Reservable {
    boolean checkAvailability();
    void reserveItem(String borrowerName);
}

abstract class LibraryItem implements Reservable {
    private final String itemId;
    private final String title;
    private final String author;
    private String borrowerName;

    LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
        System.out.println("Available: " + checkAvailability());
    }

    @Override
    public boolean checkAvailability() {
        return borrowerName == null;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!checkAvailability()) {
            System.out.println(title + " is already reserved.");
        } else if (borrowerName == null || borrowerName.isBlank()) {
            System.out.println("A borrower name is required.");
        } else {
            this.borrowerName = borrowerName;
            System.out.println(title + " has been reserved.");
        }
    }
}

class Book extends LibraryItem {
    Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    int getLoanDuration() {
        return 14;
    }
}

class Magazine extends LibraryItem {
    Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    int getLoanDuration() {
        return 7;
    }
}

class DVD extends LibraryItem {
    DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    int getLoanDuration() {
        return 3;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B101", "The Hobbit", "J. R. R. Tolkien"));
        items.add(new Magazine("M101", "Science Today", "Editorial Team"));
        items.add(new DVD("D101", "Planet Earth", "BBC"));

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan duration: " + item.getLoanDuration() + " days");
            item.reserveItem("Mihir");
            System.out.println("Available now: " + item.checkAvailability());
            System.out.println();
        }
    }
}
