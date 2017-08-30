package airport;

import airport.exceptions.AirportDoesNotExistException;
import airport.seeds.FlightRepositorySeed;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FlightFinderTest {
    @Test
    public void shouldFindFlight() throws AirportDoesNotExistException {
        FlightRepositorySeed.populate();

        AirportFactory airportFactory = new AirportFactory();

        FlightFinder flightFinder = new FlightFinder();

        List<Flight> flight = flightFinder.find(City.RECIFE, City.RIO_DE_JANEIRO);

        String loc = "MCAKKL";
        FlightCompanies company = FlightCompanies.LATAM;
        Route route = new Route(airportFactory.getAirport(AirportCode.REC), airportFactory.getAirport(AirportCode.GIG));
        TravelTime travelTime = new TravelTime(LocalTime.of(9, 30), LocalTime.of(10, 30));

        List<Flight> expectedFlight = Collections.singletonList(new Flight(loc, company, route, travelTime));

        assertThat(flight, is(expectedFlight));
    }

    
}
