package Java_Streams.AddressBookSystem;

public class Contact {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phone;
    String email;

    public Contact(String firstName, String lastName, String address, String city,
            String state, String zip, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) obj;
        return firstName.equals(other.firstName) && lastName.equals(other.lastName);
    }

    @Override
    public int hashCode() {
        // Equal contacts must also have equal hash codes.
        return firstName.hashCode() + lastName.hashCode();
    }

    @Override
    public String toString() {
        return fullName() + " | " + address + " | " + city + " | " + state + " | " + zip
                + " | " + phone + " | " + email;
    }
}
