package TDD;

public class InvoiceService {
    private final RideRepository rideRepository;
    private final CabInvoiceGenerator invoiceGenerator;

    public InvoiceService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
        this.invoiceGenerator = new CabInvoiceGenerator();
    }

    public Invoice getInvoice(String userId) {
        Ride[] rides = rideRepository.getRides(userId).toArray(new Ride[0]);
        return invoiceGenerator.calculateFare(rides);
    }
}
