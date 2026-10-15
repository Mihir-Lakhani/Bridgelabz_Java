package Java_Streams.AddressBookSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// One integrated implementation of Week 4 Streams UC7-UC12.
public class AddressBookService {
    private final Map<String, AddressBook> books = new LinkedHashMap<>();

    public boolean createBook(String name) {
        if (name == null || name.trim().isEmpty() || books.containsKey(name.trim())) return false;
        books.put(name.trim(), new AddressBook());
        return true;
    }

    public AddressBook getBook(String name) { return books.get(name); }
    public List<String> bookNames() { return new ArrayList<>(books.keySet()); }

    public boolean addContact(String bookName, Contact contact) {
        AddressBook book = books.get(bookName);
        return book != null && book.add(contact);
    }

    Stream<Contact> allContacts() {
        return books.values().stream().flatMap(book -> book.getContacts().stream());
    }

    // UC8: search across every book. A person in separate books is counted in each.
    public List<Contact> searchByCity(String city) {
        return allContacts().filter(contact -> contact.city.equalsIgnoreCase(city.trim()))
                .collect(Collectors.toList());
    }

    public List<Contact> searchByState(String state) {
        return allContacts().filter(contact -> contact.state.equalsIgnoreCase(state.trim()))
                .collect(Collectors.toList());
    }

    // UC9: rebuild dictionaries from current contacts, avoiding stale indexes after edits.
    public Map<String, List<Contact>> personsByCity() {
        return allContacts().collect(Collectors.groupingBy(Contact::getCity,
                () -> new TreeMap<>(String.CASE_INSENSITIVE_ORDER), Collectors.toList()));
    }

    public Map<String, List<Contact>> personsByState() {
        return allContacts().collect(Collectors.groupingBy(Contact::getState,
                () -> new TreeMap<>(String.CASE_INSENSITIVE_ORDER), Collectors.toList()));
    }

    // UC10: counting() produces Long counts.
    public Map<String, Long> countByCity() {
        return allContacts().collect(Collectors.groupingBy(Contact::getCity,
                () -> new TreeMap<>(String.CASE_INSENSITIVE_ORDER), Collectors.counting()));
    }

    public Map<String, Long> countByState() {
        return allContacts().collect(Collectors.groupingBy(Contact::getState,
                () -> new TreeMap<>(String.CASE_INSENSITIVE_ORDER), Collectors.counting()));
    }

    private List<Contact> sorted(String bookName, Comparator<Contact> comparator) {
        AddressBook book = books.get(bookName);
        if (book == null) return Collections.emptyList();
        return book.getContacts().stream().sorted(comparator
                .thenComparing(Contact::fullName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    // UC11: alphabetical means first name, then last name, ignoring case.
    public List<Contact> sortByName(String bookName) {
        return sorted(bookName, Comparator.comparing(Contact::getFirstName, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Contact::getLastName, String.CASE_INSENSITIVE_ORDER));
    }

    // UC12: separate functions; sorted copies retain contacts with equal city/state/zip.
    public List<Contact> sortByCity(String bookName) {
        return sorted(bookName, Comparator.comparing(Contact::getCity, String.CASE_INSENSITIVE_ORDER));
    }

    public List<Contact> sortByState(String bookName) {
        return sorted(bookName, Comparator.comparing(Contact::getState, String.CASE_INSENSITIVE_ORDER));
    }

    public List<Contact> sortByZip(String bookName) {
        return sorted(bookName, Comparator.comparing(Contact::getZip));
    }
}
