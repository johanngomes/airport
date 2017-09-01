package manager;

import manager.airport.AirportCode;
import manager.airport.AirportFactory;
import manager.exceptions.AirportDoesNotExistException;
import org.junit.Test;

import java.time.LocalTime;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FlightRepositoryTest {
    @Test
    public void shouldAddFlight() throws AirportDoesNotExistException {
        FlightRepository.removeAll();

        String loc = "KSTVWO";
        FlightCompanies company = FlightCompanies.GOL;

        AirportFactory airportFactory = new AirportFactory();

        Route route = new Route(airportFactory.getAirport(AirportCode.GIG), airportFactory.getAirport(AirportCode.GRU));
        TravelTime travelTime = new TravelTime(LocalTime.of(11, 00), LocalTime.of(16, 30));

        Flight flight = new Flight(loc, company, route, travelTime);

        FlightRepository.add(flight);

        List<Flight> expectedFlights = singletonList(flight);

        assertThat(FlightRepository.getFlights(), is(expectedFlights));
    }
}
