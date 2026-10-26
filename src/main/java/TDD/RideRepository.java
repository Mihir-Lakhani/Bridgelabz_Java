package TDD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    private final Map<String, List<Ride>> ridesByUser = new HashMap<>();

    public void addRide(String userId, Ride ride) {
        ridesByUser.computeIfAbsent(userId, id -> new ArrayList<>()).add(ride);
    }

    public List<Ride> getRides(String userId) {
        List<Ride> rides = ridesByUser.get(userId);
        return rides == null ? new ArrayList<>() : new ArrayList<>(rides);
    }
}
