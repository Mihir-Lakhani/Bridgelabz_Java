package Java_Streams.AddressBookSystem;

import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

    static void display(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found");
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Address Book System");

        AddressBookService service = new AddressBookService();
        service.createBook("Home");
        service.createBook("Work");

        Contact mihir = new Contact("Mihir", "Lakhani", "Main Road", "Chennai",
                "TN", "600001", "9919819801", "mihir@example.com");
        Contact asha = new Contact("Asha", "Shah", "Park Road", "Pune",
                "MH", "411001", "9876543210", "asha@example.com");
        Contact bob = new Contact("Bob", "Rao", "Lake Road", "Chennai",
                "TN", "600002", "9123456780", "bob@example.com");
        service.addContact("Home", mihir);
        service.addContact("Home", asha);
        service.addContact("Work", bob);

        // UC7: the same first and last name is rejected in this book.
        Contact duplicate = new Contact("Mihir", "Lakhani", "Other Road", "Pune",
                "MH", "411001", "9999999999", "other@example.com");
        System.out.println("UC7 - Duplicate added: " + service.addContact("Home", duplicate));

        System.out.println("UC8 - People in Chennai:");
        display(service.searchByCity("Chennai"));
        System.out.println("UC8 - People in MH:");
        display(service.searchByState("MH"));

        System.out.println("UC9 - City groups: " + service.personsByCity());
        System.out.println("UC9 - State groups: " + service.personsByState());
        System.out.println("UC10 - City counts: " + service.countByCity());
        System.out.println("UC10 - State counts: " + service.countByState());

        // UC11: select a book using the console.
        System.out.println("Enter book name to sort (Home or Work):");
        String bookName = "Home";
        if (scanner.hasNextLine()) {
            bookName = scanner.nextLine();
        }
        if (service.getBook(bookName) == null) {
            System.out.println("Book not found");
            return;
        }
        System.out.println("UC11 - Sorted by name:");
        display(service.sortByName(bookName));

        System.out.println("UC12 - Sorted by city:");
        display(service.sortByCity(bookName));
        System.out.println("UC12 - Sorted by state:");
        display(service.sortByState(bookName));
        System.out.println("UC12 - Sorted by zip:");
        display(service.sortByZip(bookName));
    }
}
