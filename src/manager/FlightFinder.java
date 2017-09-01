package manager;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class FlightFinder {
    public List<Flight> find(City from, City to) {
        List<Flight> directFlight = findDirectFlight(from, to);

        if(!directFlight.isEmpty()) {
            return directFlight;
        }

        List<Flight> flightsFrom = getAnyFlightFrom(from);
        List<Flight> flightsTo = getAnyFlightTo(to, getAnyFlightFrom(from));

        return asList(flightsFrom.get(0), flightsTo.get(0));
    }

    private List<Flight> getAnyFlightTo(City to, List<Flight> flightsFrom) {
        return flightsFrom.stream()
                .map(flight -> findDirectFlight(flight.getRoute().getTo().getCity(), to))
                .filter(flight -> !flight.isEmpty())
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<Flight> getAnyFlightFrom(City from) {
        return FlightRepository.getFlights().stream()
                    .filter(flight -> flightIsFrom(from, flight))
                    .collect(Collectors.toList());
    }

    private List<Flight> findDirectFlight(City from, City to) {
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
