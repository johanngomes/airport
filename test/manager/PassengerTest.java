package manager;

import manager.airport.AirportCode;
import manager.airport.AirportFactory;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PassengerTest {

    @Test
    public void shouldBookAFlight() throws Exception {
        Passenger passenger = new Passenger("09414280449", "Johann Gomes");

        String loc = "KSTVWO";
        FlightCompany company = FlightCompany.GOL;

        AirportFactory airportFactory = new AirportFactory();

        Route route = new Route(airportFactory.getAirport(AirportCode.GIG), airportFactory.getAirport(AirportCode.GRU));
        TravelTime travelTime = new TravelTime(LocalTime.of(11, 00), LocalTime.of(16, 30));
        Flight flight = new Flight(loc, company, route, travelTime);

        Booking expectedBooking = new Booking(passenger, flight);

        Booking booking = passenger.book(flight);

        assertThat(booking, is(expectedBooking));
    }

    @Test(expected = Exception.class)
    public void shouldNotCreateAPassengerWithNumberOfDigitsCPFThatIsLessThan11() throws Exception {
        new Passenger("09414280", "Johann Gomes");
    }

    @Test(expected = Exception.class)
    public void shouldNotCreateAPassengerWithNumberOfDigitsCPFThatIsMoreThan11() throws Exception {
        new Passenger("094142827621656520", "Johann Gomes");
    }

    @Test(expected = Exception.class)
    public void shouldNotCreateAPassaengerWithNameWithoutSurname() throws Exception {
        new Passenger("09414280447", "Johann");
    }
}
