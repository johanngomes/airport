package manager.airport;

import manager.City;
import manager.Country;
import manager.airport.Airport;
import manager.airport.AirportCode;

public class RECAirport extends Airport {
    public RECAirport() {
        super(AirportCode.REC, Country.BRAZIL, City.RECIFE);
    }
}
