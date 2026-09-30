/*
Sample Program 2: Library Management System
Create a Book class to manage library books with the following features:
Static:
A static variable libraryName shared across all books.
A static method displayLibraryName() to print the library name.
This:
Use this to initialize title, author, and isbn in the constructor.
Final:
Use a final variable isbn to ensure the unique identifier of a book cannot be changed.
Instanceof:
Verify if an object is an instance of the Book class before displaying its details.
 */

package Java_ThisStaticFinalAndInstanceOf;

import java.util.Scanner;


class Book{
    static String libraryName;
    final int isbn;
    private String title;
    private String author;

    Scanner sc = new Scanner(System.in);

    Book(){
        System.out.print("Enter isbn: ");
        isbn = sc.nextInt();
    }
    Book(int isbn, String title, String author){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }

    public static void Display(Book obj){
        System.out.printf("LibraryName: %s\n", libraryName);
        System.out.printf("isbn: %s\n", obj.isbn);
        System.out.printf("TitleName: %s\n", obj.title);
        System.out.printf("AuthorName: %s\n", obj.author);
        System.out.println("=============================");
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book.libraryName = "UB";
        Book b1 = new Book();
        b1.setAuthor("J. k.");
        b1.setTitle("H. P.");
        if(b1 instanceof Book){
            Book.Display(b1);
        }

        Book b2 = new Book(7665, "J. k. 2", "H. P. 2");

        Book.Display(b2);


    }
}