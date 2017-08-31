package airport;

import airport.exceptions.AirportDoesNotExistException;
import airport.seeds.FlightRepositorySeed;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FlightFinderTest {
    private AirportFactory airportFactory;
    private FlightFinder flightFinder;

    @Before
    public void setUp() throws AirportDoesNotExistException {
        FlightRepositorySeed.populate();

        airportFactory = new AirportFactory();
        flightFinder = new FlightFinder();
    }

    @Test
    public void shouldFindFlight() throws AirportDoesNotExistException {
        List<Flight> flight = flightFinder.find(City.RECIFE, City.RIO_DE_JANEIRO);

        String loc = "MCAKKL";
        FlightCompanies company = FlightCompanies.LATAM;
        Route route = new Route(airportFactory.getAirport(AirportCode.REC), airportFactory.getAirport(AirportCode.GIG));
        TravelTime travelTime = new TravelTime(LocalTime.of(9, 30), LocalTime.of(10, 30));

        List<Flight> expectedFlight = Collections.singletonList(new Flight(loc, company, route, travelTime));

        assertThat(flight, is(expectedFlight));
    }

    @Test
    public void shouldFindFlightsWhenThereIsNoDirectFlight() throws AirportDoesNotExistException {
        List<Flight> flight = flightFinder.find(City.RECIFE, City.PORTO_ALEGRE);

        String locSpFlight = "KSTVWO";
        FlightCompanies companySpFlight = FlightCompanies.GOL;
        Route routeSpFlight = new Route(airportFactory.getAirport(AirportCode.REC), airportFactory.getAirport(AirportCode.GRU));
        TravelTime travelTimeSpFlight = new TravelTime(LocalTime.of(11, 00), LocalTime.of(13, 00));
        Flight flightToSp = new Flight(locSpFlight, companySpFlight, routeSpFlight, travelTimeSpFlight);

        String locPoaFlight = "KAAVRO";
        FlightCompanies companyPoaFlight = FlightCompanies.GOL;
        Route routePoaFlight = new Route(airportFactory.getAirport(AirportCode.GRU), airportFactory.getAirport(AirportCode.POA));
        TravelTime travelTimePoaFlight = new TravelTime(LocalTime.of(13, 30), LocalTime.of(15, 20));
        Flight flightToPoa = new Flight(locPoaFlight, companyPoaFlight, routePoaFlight, travelTimePoaFlight);

        List<Flight> expectedFlight = Arrays.asList(flightToSp, flightToPoa);

        assertThat(flight, is(expectedFlight));
    }
}
