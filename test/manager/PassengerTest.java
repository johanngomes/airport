package manager;

import manager.airport.AirportCode;
import manager.airport.AirportFactory;
import manager.exceptions.AirportDoesNotExistException;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PassengerTest {

    @Test
    public void shouldBookAFlight() throws AirportDoesNotExistException {
        Passenger passenger = new Passenger("09660898", "Johann");

        String loc = "KSTVWO";
        FlightCompanies company = FlightCompanies.GOL;

        AirportFactory airportFactory = new AirportFactory();

        Route route = new Route(airportFactory.getAirport(AirportCode.GIG), airportFactory.getAirport(AirportCode.GRU));
        TravelTime travelTime = new TravelTime(LocalTime.of(11, 00), LocalTime.of(16, 30));
        Flight flight = new Flight(loc, company, route, travelTime);

        Booking expectedBooking = new Booking(passenger, flight);

        Booking booking = passenger.book(flight);

        assertThat(booking, is(expectedBooking));
    }

}
