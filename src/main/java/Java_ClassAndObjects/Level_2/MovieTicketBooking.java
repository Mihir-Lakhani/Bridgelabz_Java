/*
4. Program to Model a Movie Ticket Booking System
Problem Statement: Create a MovieTicket class with attributes movieName, seatNumber, and price.
Add methods to book a ticket (assign seat and update price) and display ticket details.
 */

package Java_ClassAndObjects.Level_2;

class MovieTicket{

    String movieName;
    int seatNumber;
    int price;

    MovieTicket(String movieName){
        this.movieName = movieName;
    }

    public void bookTicket(int seatNumber, int price){
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket Booked");
    }

    public void displayDetails(){
        System.out.printf("Movie Name: %s\n", this.movieName);
        System.out.printf("Seat Number: %d\n", this.seatNumber);
        System.out.printf("Ticket Price: Rs.%d\n", this.price);
    }

}

public class MovieTicketBooking {
    public static void main(String[] args) {

        MovieTicket t1 = new MovieTicket("3 Idiots");
        t1.bookTicket(12, 250);
        t1.displayDetails();

    }
}
