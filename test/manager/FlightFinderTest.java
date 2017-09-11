package manager;

import manager.airport.AirportFactory;
import manager.exceptions.AirportDoesNotExistException;
import manager.seeds.FlightRepositorySeed;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static manager.City.PORTO_ALEGRE;
import static manager.City.RECIFE;
import static manager.City.RIO_DE_JANEIRO;
import static manager.airport.AirportCode.GIG;
import static manager.airport.AirportCode.GRU;
import static manager.airport.AirportCode.POA;
import static manager.airport.AirportCode.REC;
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
        List<Flight> flight = flightFinder.find(RECIFE, RIO_DE_JANEIRO);

        String loc = "MCAKKL";
        FlightCompany company = FlightCompany.LATAM;
        Route route = new Route(airportFactory.getAirport(REC), airportFactory.getAirport(GIG));
        TravelTime travelTime = new TravelTime(LocalTime.of(9, 30), LocalTime.of(10, 30));

        List<Flight> expectedFlight = Collections.singletonList(new Flight(loc, company, route, travelTime));

        assertThat(flight, is(expectedFlight));
    }

    @Test
    public void shouldFindFlightsWhenThereIsNoDirectFlightButOneConnection() throws AirportDoesNotExistException {
        List<Flight> flights = flightFinder.find(RECIFE, PORTO_ALEGRE);

        String locSpFlight = "KSTVWO";
        FlightCompany companySpFlight = FlightCompany.GOL;
        Route routeSpFlight = new Route(airportFactory.getAirport(REC), airportFactory.getAirport(GRU));
        TravelTime travelTimeSpFlight = new TravelTime(LocalTime.of(11, 00), LocalTime.of(13, 00));
        Flight flightToSp = new Flight(locSpFlight, companySpFlight, routeSpFlight, travelTimeSpFlight);

        String locPoaFlight = "KAAVRO";
        FlightCompany companyPoaFlight = FlightCompany.GOL;
        Route routePoaFlight = new Route(airportFactory.getAirport(GRU), airportFactory.getAirport(POA));
        TravelTime travelTimePoaFlight = new TravelTime(LocalTime.of(13, 30), LocalTime.of(15, 20));
        Flight flightToPoa = new Flight(locPoaFlight, companyPoaFlight, routePoaFlight, travelTimePoaFlight);

        List<Flight> expectedFlights = Arrays.asList(flightToSp, flightToPoa);

        assertThat(flights, is(expectedFlights));
    }
}
