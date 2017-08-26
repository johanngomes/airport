package airport;

import airport.exceptions.AirportDoesNotExistException;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FlightRepositoryTest {

    @Test
    public void shouldAddFlight() throws AirportDoesNotExistException {
        FlightRepository flightRepository = new FlightRepository();

        String loc = "KSTVWO";
        FlightCompanies company = FlightCompanies.GOL;

        AirportFactory airportFactory = new AirportFactory();

        Route route = new Route(airportFactory.getAirport(AirportCode.GIG), airportFactory.getAirport(AirportCode.GRU));
        TravelTime travelTime = new TravelTime(LocalTime.of(11, 00), LocalTime.of(16, 30));

        Flight flight = new Flight(loc, company, route, travelTime);

        flightRepository.add(flight);

        List<Flight> expectedFlights = Arrays.asList(flight);

        assertThat(flightRepository.getFlights(), is(expectedFlights));
    }

}
