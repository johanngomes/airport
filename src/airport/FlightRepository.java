package airport;

import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private static List<Flight> flights = new ArrayList<>();

    public static void add(Flight flight) {
        flights.add(flight);
    }

    public static void removeAll() {
        flights = new ArrayList<>();
    }

    public static List<Flight> getFlights() {
        return flights;
    }
}
