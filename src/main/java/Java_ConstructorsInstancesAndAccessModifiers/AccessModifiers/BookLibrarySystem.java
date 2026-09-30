package Java_ConstructorsInstancesAndAccessModifiers.AccessModifiers;

import java.util.Scanner;


class Book{
    final public long ISBN;
    protected String title;
    private String author;

    Book(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the ISBN number: ");
        ISBN = input.nextLong();
    }
    Book(long ISBN){
        this.ISBN = ISBN;
    }

    public void SetAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }

}

class EBook extends Book{

    EBook(){
        super();
    }

    EBook(long ISBN){
        super(ISBN);
    }

    public void SetTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public long GetISBN(){
        return ISBN;
    }
    public void Display(){
        System.out.printf("ISBN Number is %d\n", ISBN);
        System.out.printf("Title is %s\n", title);
        System.out.printf("Author is %s\n", getAuthor());
    }
}


public class BookLibrarySystem {
    public static void main(String[] args) {

        EBook eb1 = new EBook();
        EBook eb2 = new EBook(1234328546);
        eb1.SetAuthor("J K R.");
        eb2.SetAuthor("J K R. 2");
        eb1.SetTitle("H. P.");
        eb2.SetTitle("H. P. 2");
        eb1.Display();
        eb2.Display();



    }
}