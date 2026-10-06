package Java_ObjectMoldelingAndClassDiagram.ObjectModeling.AssistedProblems.LibraryAndBooks;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


class Book {

    private String author;
    private String title;

    Book(String author, String title){
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

}