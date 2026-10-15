package Java_Streams.AddressBookSystem;

import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

    static Contact sample(String first, String last, String city, String state, String zip) {
        return new Contact(first, last, "Main Road", city, state, zip,
                "91 9919819801", first.toLowerCase(java.util.Locale.ROOT) + "@example.com");
    }

    static AddressBookService sampleBooks() {
        AddressBookService service = new AddressBookService();
        service.createBook("Home");
        service.createBook("Work");
        service.addContact("Home", sample("Mihir", "Lakhani", "Chennai", "TN", "600001"));
        service.addContact("Home", sample("Asha", "Shah", "Pune", "MH", "411001"));
        service.addContact("Home", sample("Zara", "Patel", "Chennai", "TN", "600002"));
        service.addContact("Work", sample("Bob", "Rao", "Chennai", "TN", "600002"));
        return service;
    }

    static void display(List<Contact> contacts) {
        if (contacts.isEmpty()) System.out.println("No contacts found");
        else contacts.forEach(System.out::println);
    }

    static void demo(AddressBookService service) {
        System.out.println("UC7 - Duplicate accepted: " + service.addContact("Home",
                sample("Mihir", "Lakhani", "Pune", "MH", "411001")));
        System.out.println("UC8 - People in Chennai:");
        display(service.searchByCity("Chennai"));
        System.out.println("UC8 - People in MH:");
        display(service.searchByState("MH"));
        System.out.println("UC9 - City dictionary: " + service.personsByCity());
        System.out.println("UC9 - State dictionary: " + service.personsByState());
        System.out.println("UC10 - City counts: " + service.countByCity());
        System.out.println("UC10 - State counts: " + service.countByState());
        System.out.println("UC11 - Home sorted by name:");
        display(service.sortByName("Home"));
        System.out.println("UC12 - Home sorted by city:");
        display(service.sortByCity("Home"));
        System.out.println("UC12 - Home sorted by state:");
        display(service.sortByState("Home"));
        System.out.println("UC12 - Home sorted by zip:");
        display(service.sortByZip("Home"));
    }

    static String read(Scanner scanner, String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    static Contact readContact(Scanner scanner) {
        String first = read(scanner, "First name:");
        String last = read(scanner, "Last name:");
        String address = read(scanner, "Address:");
        String city = read(scanner, "City:");
        String state = read(scanner, "State:");
        String zip = read(scanner, "Zip (kept as text):");
        String phone = read(scanner, "Phone:");
        String email = read(scanner, "Email:");
        return new Contact(first, last, address, city, state, zip, phone, email);
    }

    static void interactive(AddressBookService service) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 Create book | 2 Add contact | 3 Edit | 4 Delete | 5 Display book");
            System.out.println("6 Search city | 7 Search state | 8 City groups | 9 State groups");
            System.out.println("10 Counts | 11 Sort name | 12 Sort city | 13 Sort state | 14 Sort zip | 0 Exit");
            if (!scanner.hasNextLine()) return;
            String choice = scanner.nextLine().trim();
            if (choice.equals("0")) return;
            switch (choice) {
                case "1":
                    System.out.println("Book created: " + service.createBook(read(scanner, "Book name:")));
                    break;
                case "2": {
                    String name = read(scanner, "Book name:");
                    if (service.getBook(name) == null) System.out.println("Unknown book");
                    else System.out.println("Contact added: " + service.addContact(name, readContact(scanner)));
                    break;
                }
                case "3":
                case "4": {
                    AddressBook book = service.getBook(read(scanner, "Book name:"));
                    if (book == null) { System.out.println("Unknown book"); break; }
                    String first = read(scanner, "Existing first name:");
                    String last = read(scanner, "Existing last name:");
                    if (choice.equals("3")) {
                        if (!book.find(first, last).isPresent()) System.out.println("Contact not found");
                        else System.out.println("Contact edited: " + book.edit(first, last, readContact(scanner)));
                    } else System.out.println("Contact deleted: " + book.delete(first, last));
                    break;
                }
                case "5": {
                    AddressBook book = service.getBook(read(scanner, "Book name:"));
                    if (book == null) System.out.println("Unknown book");
                    else display(book.getContacts());
                    break;
                }
                case "6": display(service.searchByCity(read(scanner, "City:"))); break;
                case "7": display(service.searchByState(read(scanner, "State:"))); break;
                case "8": System.out.println(service.personsByCity()); break;
                case "9": System.out.println(service.personsByState()); break;
                case "10":
                    System.out.println("City: " + service.countByCity());
                    System.out.println("State: " + service.countByState());
                    break;
                case "11":
                case "12":
                case "13":
                case "14": {
                    String name = read(scanner, "Book to sort (" + service.bookNames() + "):");
                    if (service.getBook(name) == null) { System.out.println("Unknown book"); break; }
                    if (choice.equals("11")) display(service.sortByName(name));
                    else if (choice.equals("12")) display(service.sortByCity(name));
                    else if (choice.equals("13")) display(service.sortByState(name));
                    else display(service.sortByZip(name));
                    break;
                }
                default: System.out.println("Choose an option from 0 to 14");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");
        AddressBookService service = sampleBooks();
        if (args.length > 0 && args[0].equals("--interactive")) interactive(service);
        else {
            demo(service);
            System.out.println("Use --interactive for console entry, edits, searches and sorting.");
        }
    }
}
