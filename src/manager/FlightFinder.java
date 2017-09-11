package manager;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class FlightFinder {

    //find a direct flight from a city to another city
    //if there is no direct flight between these destinations
    //then, we should find two flights, that connects these two destinations
    public List<Flight> find(City from, City to) {
        List<Flight> directFlight = findDirectFlight(from, to);

        if(!directFlight.isEmpty()) {
            return directFlight;
        }

        List<Flight> flightsFrom = getAnyFlightFrom(from);
        List<Flight> flightsTo = getAnyFlightTo(to, getAnyFlightFrom(from));

        return asList(flightsFrom.get(0), flightsTo.get(0));
    }

    public List<Flight> getAnyFlightTo(City to, List<Flight> flightsFrom) {
        return flightsFrom.stream()
                .map(flight -> findDirectFlight(flight.getRoute().getTo().getCity(), to))
                .filter(flight -> !flight.isEmpty())
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<Flight> getAnyFlightFrom(City from) {
        return FlightRepository.getFlights().stream()
                    .filter(flight -> flightIsFrom(from, flight))
                    .collect(Collectors.toList());
    }

    public List<Flight> findDirectFlight(City city1, City city2) {
        return FlightRepository.getFlights().stream()
                .filter(flight -> flightIsFrom(city1, flight) && flightIsTo(city2, flight))
                .collect(Collectors.toList());
    }

    public boolean flightIsFrom(City from, Flight flight) {
        return flight.getRoute().getFrom().getCity().equals(from);
    }

    public boolean flightIsTo(City to, Flight flight) {
        return flight.getRoute().getTo().getCity().equals(to);
    }

    public boolean findConnectionFlight(Flight flight){
        if (!false){
            return true;
        }

        throw new RuntimeException("vraaa");
    }
}
