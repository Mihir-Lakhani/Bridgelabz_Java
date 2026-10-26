package TDD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CabInvoiceGeneratorTest {
    private final CabInvoiceGenerator generator = new CabInvoiceGenerator();

    @Test
    void calculatesFareFromDistanceAndTime() {
        assertEquals(55, generator.calculateFare(5, 5), 0.001);
    }

    @Test
    void appliesMinimumFare() {
        assertEquals(5, generator.calculateFare(0.2, 1), 0.001);
    }

    @Test
    void createsInvoiceForMultipleRides() {
        Ride[] rides = {
                new Ride(10, 5),
                new Ride(2, 1)
        };

        Invoice invoice = generator.calculateFare(rides);

        assertEquals(2, invoice.getTotalRides());
        assertEquals(126, invoice.getTotalFare(), 0.001);
        assertEquals(63, invoice.getAverageFarePerRide(), 0.001);
    }

    @Test
    void invoiceServiceGetsRidesForTheGivenUser() {
        RideRepository repository = new RideRepository();
        repository.addRide("user-1", new Ride(10, 5));
        repository.addRide("user-1", new Ride(2, 1));
        repository.addRide("user-2", new Ride(1, 1));
        InvoiceService invoiceService = new InvoiceService(repository);

        Invoice invoice = invoiceService.getInvoice("user-1");

        assertEquals(2, invoice.getTotalRides());
        assertEquals(126, invoice.getTotalFare(), 0.001);
    }

    @Test
    void calculatesPremiumFareAndMinimum() {
        assertEquals(32, generator.calculateFare(new Ride(2, 1, true)), 0.001);
        assertEquals(20, generator.calculateFare(new Ride(0.5, 1, true)), 0.001);
    }
}
