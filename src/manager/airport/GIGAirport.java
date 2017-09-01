package manager.airport;

import manager.City;
import manager.Country;
import manager.airport.Airport;
import manager.airport.AirportCode;

public class GIGAirport extends Airport {
    public GIGAirport() {
        super(AirportCode.GIG, Country.BRAZIL, City.RIO_DE_JANEIRO);
    }
}
