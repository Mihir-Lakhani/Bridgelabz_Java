package TDD;

public class Ride {
    private final double distance;
    private final int time;
    private final boolean premium;

    public Ride(double distance, int time) {

        this(distance, time, false);
    }

    public Ride(double distance, int time, boolean premium) {
        this.distance = distance;
        this.time = time;
        this.premium = premium;
    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public boolean isPremium() {
        return premium;
    }
}
