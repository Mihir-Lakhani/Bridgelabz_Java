package Java_Streams.AddressBookSystem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookService {
    Map<String, AddressBook> books = new LinkedHashMap<>();

    public boolean createBook(String name) {
        if (name == null || name.trim().isEmpty() || books.containsKey(name)) {
            return false;
        }
        books.put(name, new AddressBook());
        return true;
    }

    public AddressBook getBook(String name) {
        return books.get(name);
    }

    public boolean addContact(String bookName, Contact contact) {
        AddressBook book = books.get(bookName);
        if (book == null) {
            return false;
        }
        return book.add(contact);
    }

    // Combine contacts using a simple loop instead of nested streams.
    public List<Contact> getAllContacts() {
        List<Contact> allContacts = new ArrayList<>();
        for (AddressBook book : books.values()) {
            allContacts.addAll(book.getContacts());
        }
        return allContacts;
    }

    // UC8: search across all address books.
    public List<Contact> searchByCity(String city) {
        return getAllContacts().stream()
                .filter(contact -> contact.city.equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Contact> searchByState(String state) {
        return getAllContacts().stream()
                .filter(contact -> contact.state.equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    // UC9: group people by city or state.
    public Map<String, List<Contact>> personsByCity() {
        return getAllContacts().stream()
                .collect(Collectors.groupingBy(contact -> contact.city));
    }

    public Map<String, List<Contact>> personsByState() {
        return getAllContacts().stream()
                .collect(Collectors.groupingBy(contact -> contact.state));
    }

    // UC10: count people in each city or state.
    public Map<String, Long> countByCity() {
        return getAllContacts().stream()
                .collect(Collectors.groupingBy(contact -> contact.city, Collectors.counting()));
    }

    public Map<String, Long> countByState() {
        return getAllContacts().stream()
                .collect(Collectors.groupingBy(contact -> contact.state, Collectors.counting()));
    }

    // UC11: return contacts sorted by their full name.
    public List<Contact> sortByName(String bookName) {
        AddressBook book = books.get(bookName);
        if (book == null) {
            return new ArrayList<>();
        }
        return book.getContacts().stream()
                .sorted((a, b) -> a.fullName().compareToIgnoreCase(b.fullName()))
                .collect(Collectors.toList());
    }

    // UC12: separate functions for each sorting field.
    public List<Contact> sortByCity(String bookName) {
        AddressBook book = books.get(bookName);
        if (book == null) {
            return new ArrayList<>();
        }
        return book.getContacts().stream()
                .sorted((a, b) -> a.city.compareToIgnoreCase(b.city))
                .collect(Collectors.toList());
    }

    public List<Contact> sortByState(String bookName) {
        AddressBook book = books.get(bookName);
        if (book == null) {
            return new ArrayList<>();
        }
        return book.getContacts().stream()
                .sorted((a, b) -> a.state.compareToIgnoreCase(b.state))
                .collect(Collectors.toList());
    }

    public List<Contact> sortByZip(String bookName) {
        AddressBook book = books.get(bookName);
        if (book == null) {
            return new ArrayList<>();
        }
        return book.getContacts().stream()
                .sorted((a, b) -> a.zip.compareTo(b.zip))
                .collect(Collectors.toList());
    }
}
