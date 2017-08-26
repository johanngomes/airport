package airport;

import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    List<Flight> flights = new ArrayList<>();

    public void add(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
