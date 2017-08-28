package airport;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FlightRepository {
    List<Flight> flights = new ArrayList<>();

    public void add(Flight flight) {
        flights.add(flight);
    }
}
