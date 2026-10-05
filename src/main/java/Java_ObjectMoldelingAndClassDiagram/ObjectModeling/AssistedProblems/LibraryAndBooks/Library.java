package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.AssistedProblems.LibraryAndBooks;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Library {
    private String name;

    ArrayList<Book> books = new ArrayList<>();

    Library(String name){
        this.name = name;
    }

    void addBook(Book book){
        books.add(book);
    }

    public String getName() {
        return name;
    }

    void displayAllBooks(){
        for (Book book : books){
            System.out.println(book.getTitle()+" ("+book.getAuthor()+")");
        }
    }
}