package manager.airport;

import manager.City;
import manager.Country;
import manager.airport.Airport;
import manager.airport.AirportCode;

public class GRUAirport extends Airport {
    public GRUAirport() {
        super(AirportCode.GRU, Country.BRAZIL, City.SAO_PAULO);
    }
}
