package Java_Streams.AddressBookSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AddressBook {
    private final List<Contact> contacts = new ArrayList<>();

    // UC7: duplicates are defined by first + last name, within this book only.
    public boolean add(Contact contact) {
        if (contact == null || contact.firstName.isEmpty() || contact.lastName.isEmpty()) return false;
        if (contacts.stream().anyMatch(contact::equals)) return false;
        contacts.add(contact);
        return true;
    }

    public Optional<Contact> find(String first, String last) {
        return contacts.stream().filter(contact -> contact.hasName(first, last)).findFirst();
    }

    public boolean edit(String first, String last, Contact replacement) {
        Optional<Contact> current = find(first, last);
        if (!current.isPresent() || replacement == null || replacement.firstName.isEmpty()
                || replacement.lastName.isEmpty()) return false;
        if (contacts.stream().anyMatch(contact -> contact != current.get() && contact.equals(replacement))) {
            return false;
        }
        contacts.set(contacts.indexOf(current.get()), replacement);
        return true;
    }

    public boolean delete(String first, String last) {
        return contacts.removeIf(contact -> contact.hasName(first, last));
    }

    public List<Contact> getContacts() { return Collections.unmodifiableList(contacts); }
}
