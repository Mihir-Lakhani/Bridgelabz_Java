/*
3. Hotel Booking System: Create a HotelBooking class with attributes guestName, roomType, and nights.
Use default, parameterized, and copy constructors to initialize bookings.
 */

package Java_ConstructorsInstancesAndAccessModifiers.Constructors;

import java.util.Scanner;

class HotelBooking{
    String guestName;
    String roomType;
    int nights;

    HotelBooking(){
        guestName = "unknown";
        roomType="With AC";
        nights=1;
    }

    HotelBooking(String guestName, String roomType, int nights){
        this.guestName = guestName;
        this.roomType=roomType;
        this.nights=nights;
    }

    HotelBooking(HotelBooking other){
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights= other.nights;
    }
}

public class HotelBookingDetails {
    public static void main(String[] args) {


        HotelBooking p1 = new HotelBooking("Mihir", "AC Double Bed", 3);
        HotelBooking p2 = new HotelBooking();
        HotelBooking p3 = new HotelBooking(p1);

        Person d1 = new Person("Mihir", 21); //Juct checking the Package private Access Modifier
        d1.display();

    }
}