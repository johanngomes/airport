package manager;

import manager.airport.Airport;
import manager.airport.AirportCode;
import manager.airport.AirportFactory;
import manager.airport.GIGAirport;
import manager.airport.GRUAirport;
import manager.exceptions.AirportDoesNotExistException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class AirportFactoryTest {
    @Test
    public void shouldGetGRUAirport() throws AirportDoesNotExistException {
        AirportFactory airportFactory = new AirportFactory();
        Airport airport = airportFactory.getAirport(AirportCode.GRU);

        assertThat(airport, instanceOf(GRUAirport.class));
    }

    @Test
    public void shouldGetGIGAirport() throws AirportDoesNotExistException {
        AirportFactory airportFactory = new AirportFactory();
        Airport airport = airportFactory.getAirport(AirportCode.GIG);

        assertThat(airport, instanceOf(GIGAirport.class));
    }
}
