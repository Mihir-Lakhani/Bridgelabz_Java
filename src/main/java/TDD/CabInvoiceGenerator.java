package TDD;

public class CabInvoiceGenerator {
    private static final double NORMAL_COST_PER_KILOMETER = 10;
    private static final double NORMAL_COST_PER_MINUTE = 1;
    private static final double NORMAL_MINIMUM_FARE = 5;

    private static final double PREMIUM_COST_PER_KILOMETER = 15;
    private static final double PREMIUM_COST_PER_MINUTE = 2;
    private static final double PREMIUM_MINIMUM_FARE = 20;

    public double calculateFare(double distance, int time) {
        double fare = distance * NORMAL_COST_PER_KILOMETER + time * NORMAL_COST_PER_MINUTE;
        return Math.max(fare, NORMAL_MINIMUM_FARE);
    }

    public double calculateFare(Ride ride) {
        if (ride.isPremium()) {
            double fare = ride.getDistance() * PREMIUM_COST_PER_KILOMETER
                    + ride.getTime() * PREMIUM_COST_PER_MINUTE;
            return Math.max(fare, PREMIUM_MINIMUM_FARE);
        }
        return calculateFare(ride.getDistance(), ride.getTime());
    }

    public Invoice calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride);
        }

        double averageFare = rides.length == 0 ? 0 : totalFare / rides.length;
        return new Invoice(rides.length, totalFare, averageFare);
    }
}
