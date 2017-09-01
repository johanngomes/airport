package manager.airport;

import manager.City;
import manager.Country;
import manager.airport.Airport;
import manager.airport.AirportCode;

public class BSBAirport extends Airport {
    public BSBAirport() {
        super(AirportCode.BSB, Country.BRAZIL, City.BRASILIA);
    }
}
