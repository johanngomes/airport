package airport;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFinder {
    public List<Flight> find(City from, City to) {
        return FlightRepository.getFlights().stream()
                .filter(flight -> flightIsFrom(from, flight) && flightIsTo(to, flight))
                .collect(Collectors.toList());
    }

    private boolean flightIsFrom(City from, Flight flight) {
        return flight.getRoute().getFrom().getCity().equals(from);
    }

    private boolean flightIsTo(City to, Flight flight) {
        return flight.getRoute().getTo().getCity().equals(to);
    }
}
