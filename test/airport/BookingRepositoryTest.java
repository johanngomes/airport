package airport;

import airport.exceptions.AirportDoesNotExistException;
import org.junit.Test;

import java.time.LocalTime;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookingRepositoryTest {
    @Test
    public void shouldAddBooking() throws AirportDoesNotExistException {
        BookingRepository bookingRepository = new BookingRepository();

        String loc = "KSTVWO";
        FlightCompanies company = FlightCompanies.GOL;

        AirportFactory airportFactory = new AirportFactory();

        Route route = new Route(airportFactory.getAirport(AirportCode.GIG), airportFactory.getAirport(AirportCode.GRU));
        TravelTime travelTime = new TravelTime(LocalTime.of(11, 00), LocalTime.of(16, 30));

        Flight flight = new Flight(loc, company, route, travelTime);

        Booking booking = new Booking(new Passenger("09272727", "Fulano"), flight);
        bookingRepository.add(booking);

        List<Booking> expectedBookings = singletonList(booking);

        assertThat(expectedBookings, is(bookingRepository.getBookings()));
    }
}
