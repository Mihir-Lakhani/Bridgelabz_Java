/*
9. Circular Linked List: Online Ticket Reservation System
Each ticket stores Ticket ID, Customer Name, Movie Name, Seat Number, and Booking Time.
Operations:
1. Add a ticket reservation at the end of the circular list.
2. Remove a ticket by Ticket ID.
3. Display current tickets.
4. Search by Customer Name or Movie Name.
5. Calculate the total number of booked tickets.
Hint: tail.next points to head; traversal stops after returning to head.
Booking time is supplied as text. The exercise does not model movie showtimes.
 */

package Java_LinkedLists.PracticeProblems.CircularLinkedList;

public class OnlineTicketReservationSystem {

    private class Ticket {
        private final String ticketId;
        private final String customerName;
        private final String movieName;
        private final String seatNumber;
        private final String bookingTime;
        private Ticket next;

        Ticket(String ticketId, String customerName, String movieName,
               String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
        }

        void displayTicket() {
            System.out.println("===============================");
            System.out.println("Ticket ID: " + ticketId);
            System.out.println("Customer: " + customerName);
            System.out.println("Movie: " + movieName);
            System.out.println("Seat: " + seatNumber);
            System.out.println("Booking Time: " + bookingTime);
            System.out.println("===============================");
        }
    }

    private Ticket head;
    private Ticket tail;

    private Ticket findById(String ticketId) {
        if (head == null) return null;
        Ticket current = head;
        do {
            if (current.ticketId.equals(ticketId)) return current;
            current = current.next;
        } while (current != head);
        return null;
    }

    void addEnd(String ticketId, String customerName, String movieName,
                String seatNumber, String bookingTime) {
        if (ticketId == null || ticketId.isBlank() || customerName == null || customerName.isBlank()
                || movieName == null || movieName.isBlank() || seatNumber == null || seatNumber.isBlank()
                || bookingTime == null || bookingTime.isBlank()) {
            System.out.println("Ticket details cannot be empty");
            return;
        }
        if (findById(ticketId) != null) {
            System.out.println("Ticket ID already exists: " + ticketId);
            return;
        }

        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            newTicket.next = newTicket;
        } else {
            newTicket.next = head;
            tail.next = newTicket;
            tail = newTicket;
        }
        System.out.println("Booked ticket: " + ticketId);
    }

    void remove(String ticketId) {
        if (head == null) {
            System.out.println("No booked tickets");
            return;
        }
        Ticket previous = tail;
        Ticket current = head;
        do {
            if (current.ticketId.equals(ticketId)) {
                if (head == tail) {
                    head = tail = null;
                } else {
                    previous.next = current.next;
                    if (current == head) head = current.next;
                    if (current == tail) tail = previous;
                    tail.next = head;
                }
                current.next = null;
                System.out.println("Cancelled ticket: " + ticketId);
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
        System.out.println("Ticket not found: " + ticketId);
    }

    void displayAll() {
        if (head == null) {
            System.out.println("No booked tickets");
            return;
        }
        Ticket current = head;
        do {
            current.displayTicket();
            current = current.next;
        } while (current != head);
    }

    void searchByCustomer(String customerName) {
        if (head == null) {
            System.out.println("No booked tickets");
            return;
        }
        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(customerName)) {
                current.displayTicket();
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) System.out.println("No tickets found for customer: " + customerName);
    }

    void searchByMovie(String movieName) {
        if (head == null) {
            System.out.println("No booked tickets");
            return;
        }
        Ticket current = head;
        boolean found = false;
        do {
            if (current.movieName.equalsIgnoreCase(movieName)) {
                current.displayTicket();
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) System.out.println("No tickets found for movie: " + movieName);
    }

    int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    public static void main(String[] args) {
        OnlineTicketReservationSystem reservations = new OnlineTicketReservationSystem();
        reservations.addEnd("TK101", "Mihir", "Inception", "A1", "2026-10-08 15:00");
        reservations.addEnd("TK102", "Shrey", "Interstellar", "B2", "2026-10-08 15:05");
        reservations.addEnd("TK103", "Mihir", "Inception", "A2", "2026-10-08 15:10");
        reservations.addEnd("TK104", "Rishika", "Dangal", "C3", "2026-10-08 15:15");
        System.out.println("\n=== Current Tickets ===");
        reservations.displayAll();
        System.out.println("Total booked tickets: " + reservations.countTickets());
        System.out.println("\n=== Search by Customer ===");
        reservations.searchByCustomer("mihir");
        System.out.println("\n=== Search by Movie ===");
        reservations.searchByMovie("Inception");
        System.out.println("\n=== Cancel Middle, First, and Last Tickets ===");
        reservations.remove("TK103");
        reservations.remove("TK101");
        reservations.remove("TK104");
        reservations.displayAll();
        System.out.println("Total booked tickets: " + reservations.countTickets());
        System.out.println("\n=== Cancel the Remaining Ticket ===");
        reservations.remove("TK102");
        reservations.displayAll();
        System.out.println("Total booked tickets: " + reservations.countTickets());
    }
}
