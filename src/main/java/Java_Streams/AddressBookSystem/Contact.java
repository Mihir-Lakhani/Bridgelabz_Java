package Java_Streams.AddressBookSystem;

import java.util.Locale;
import java.util.Objects;

// Immutable contact identity prevents equals/hashCode from changing after insertion.
public class Contact {
    final String firstName;
    final String lastName;
    final String address;
    final String city;
    final String state;
    final String zip;
    final String phone;
    final String email;

    public Contact(String firstName, String lastName, String address, String city,
            String state, String zip, String phone, String email) {
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.address = address.trim();
        this.city = city.trim();
        this.state = state.trim();
        this.zip = zip.trim();
        this.phone = phone.trim();
        this.email = email.trim();
    }

    public String fullName() { return firstName + " " + lastName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }

    public boolean hasName(String first, String last) {
        return firstName.equalsIgnoreCase(first.trim()) && lastName.equalsIgnoreCase(last.trim());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Contact)) return false;
        Contact other = (Contact) obj;
        return firstName.toLowerCase(Locale.ROOT).equals(other.firstName.toLowerCase(Locale.ROOT))
                && lastName.toLowerCase(Locale.ROOT).equals(other.lastName.toLowerCase(Locale.ROOT));
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(Locale.ROOT), lastName.toLowerCase(Locale.ROOT));
    }

    @Override
    public String toString() {
        return fullName() + " | " + address + " | " + city + " | " + state + " | " + zip
                + " | " + phone + " | " + email;
    }
}
