package Java_Streams.AddressBookSystem;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    List<Contact> contacts = new ArrayList<>();

    // UC7: check for the same first and last name before adding a contact.
    public boolean add(Contact contact) {
        if (contact == null) {
            return false;
        }
        boolean duplicate = contacts.stream().anyMatch(person -> person.equals(contact));
        if (duplicate) {
            return false;
        }
        contacts.add(contact);
        return true;
    }

    public Contact find(String first, String last) {
        for (Contact contact : contacts) {
            if (contact.firstName.equals(first) && contact.lastName.equals(last)) {
                return contact;
            }
        }
        return null;
    }

    public boolean edit(String first, String last, Contact replacement) {
        Contact current = find(first, last);
        if (current == null || replacement == null) {
            return false;
        }
        for (Contact contact : contacts) {
            if (contact != current && contact.equals(replacement)) {
                return false;
            }
        }
        contacts.set(contacts.indexOf(current), replacement);
        return true;
    }

    public boolean delete(String first, String last) {
        Contact contact = find(first, last);
        return contacts.remove(contact);
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
