/*
Program 1: Library Management with Books and Authors
Create Book with a title and publication year. Extend it with Author,
which also stores the author's name and bio.
 */

package Java_Inheritance.SelfProblems.SingleInheritance;

class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Author book1 = new Author("Wings of Fire", 1999, "A. P. J. Abdul Kalam",
                "Indian scientist and former president");
        book1.displayInfo();
    }
}
