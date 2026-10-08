/*
5. Doubly Linked List: Library Management System
Problem Statement: Each book node contains Book Title, Author, Genre, Book ID,
and Availability Status. Implement the following functionalities:
1. Add a book at the beginning, end, or a specific position.
2. Remove a book by Book ID.
3. Search for a book by Book Title or Author.
4. Update a book's Availability Status.
5. Display all books in forward and reverse order.
6. Count the total number of books in the library.
Hint: Use next and prev pointers, updating both when inserting or removing.
Maintain head and tail; start from tail for reverse display.
Positions are zero-based. Availability: true = available, false = borrowed.
 */

package Java_LinkedLists.PracticeProblems.DoublyLinkedList;

public class LibraryManagementSystem {

    private class Book {
        private final String title;
        private final String author;
        private final String genre;
        private final String bookId;
        private boolean available;
        private Book next;
        private Book prev;

        Book(String title, String author, String genre, String bookId, boolean available) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.available = available;
        }

        void displayBook() {
            System.out.println("===============================");
            System.out.println("Book Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Genre: " + genre);
            System.out.println("Book ID: " + bookId);
            System.out.println("Availability: " + (available ? "Available" : "Borrowed"));
            System.out.println("===============================");
        }
    }

    private Book head;
    private Book tail;

    private Book findById(String bookId) {
        Book current = head;
        while (current != null) {
            if (current.bookId.equals(bookId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private boolean validBook(String title, String author, String genre, String bookId) {
        if (title == null || title.isBlank() || author == null || author.isBlank()
                || genre == null || genre.isBlank() || bookId == null || bookId.isBlank()) {
            System.out.println("Book title, author, genre, and ID cannot be empty");
            return false;
        }
        if (findById(bookId) != null) {
            System.out.println("Book ID already exists: " + bookId);
            return false;
        }
        return true;
    }

    void addBeginning(String title, String author, String genre,
                      String bookId, boolean available) {
        if (!validBook(title, author, genre, bookId)) {
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, available);
        newBook.next = head;

        if (head == null) {
            tail = newBook;
        } else {
            head.prev = newBook;
        }
        head = newBook;
    }

    void addEnd(String title, String author, String genre,
                String bookId, boolean available) {
        if (!validBook(title, author, genre, bookId)) {
            return;
        }
        Book newBook = new Book(title, author, genre, bookId, available);
        newBook.prev = tail;

        if (tail == null) {
            head = newBook;
        } else {
            tail.next = newBook;
        }
        tail = newBook;
    }

    // Insert AT index: 0 = beginning, current book count = end.
    void addMid(String title, String author, String genre,
                String bookId, boolean available, int index) {
        if (index < 0) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            addBeginning(title, author, genre, bookId, available);
            return;
        }

        Book current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Index is beyond the list");
            return;
        }
        if (!validBook(title, author, genre, bookId)) {
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, available);
        newBook.prev = current;
        newBook.next = current.next;

        if (current.next == null) {
            tail = newBook;
        } else {
            current.next.prev = newBook;
        }
        current.next = newBook;
    }

    void remove(String bookId) {
        Book current = findById(bookId);
        if (current == null) {
            System.out.println("No book found with ID: " + bookId);
            return;
        }

        // Connect the previous book to the following book, or move head.
        if (current.prev == null) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }

        // Update the backward link, or move tail.
        if (current.next == null) {
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }

        current.next = null;
        current.prev = null;
        System.out.println("Removed book: " + bookId);
    }

    void searchByTitle(String title) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.displayBook();
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found with title: " + title);
        }
    }

    void searchByAuthor(String author) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                current.displayBook();
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }

    void updateAvailability(String bookId, boolean available) {
        Book book = findById(bookId);
        if (book == null) {
            System.out.println("No book found with ID: " + bookId);
            return;
        }
        book.available = available;
        System.out.println("Updated " + bookId + ": " + (available ? "Available" : "Borrowed"));
    }

    void displayForward() {
        if (head == null) {
            System.out.println("Library is empty");
            return;
        }
        Book current = head;
        while (current != null) {
            current.displayBook();
            current = current.next;
        }
    }

    void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty");
            return;
        }
        Book current = tail;
        while (current != null) {
            current.displayBook();
            current = current.prev;
        }
    }

    int countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addEnd("The Hobbit", "J. R. R. Tolkien", "Fantasy", "B101", true);
        library.addBeginning("1984", "George Orwell", "Dystopian", "B102", true);
        library.addEnd("Animal Farm", "George Orwell", "Satire", "B103", false);
        library.addEnd("The Alchemist", "Paulo Coelho", "Fiction", "B104", true);
        library.addMid("Wings of Fire", "A. P. J. Abdul Kalam", "Autobiography", "B105", true, 2);

        System.out.println("=== Books in Forward Order ===");
        library.displayForward();
        System.out.println("\n=== Books in Reverse Order ===");
        library.displayReverse();
        System.out.println("Total books: " + library.countBooks());

        System.out.println("\n=== Search by Title ===");
        library.searchByTitle("the hobbit");
        System.out.println("\n=== Search by Author ===");
        library.searchByAuthor("George Orwell");

        System.out.println("\n=== Borrow The Hobbit ===");
        library.updateAvailability("B101", false);
        library.searchByTitle("The Hobbit");
        System.out.println("\n=== Return Animal Farm ===");
        library.updateAvailability("B103", true);
        library.searchByTitle("Animal Farm");

        System.out.println("\n=== Remove Middle, First, and Last Books ===");
        library.remove("B105");
        library.remove("B102");
        library.remove("B104");

        System.out.println("\n=== Remaining Books: Forward ===");
        library.displayForward();
        System.out.println("\n=== Remaining Books: Reverse ===");
        library.displayReverse();
        System.out.println("Total books: " + library.countBooks());

        System.out.println("\n=== Remove a Missing Book ===");
        library.remove("B999");
    }
}
