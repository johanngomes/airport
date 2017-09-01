package manager.airport;

import manager.City;
import manager.Country;
import manager.airport.Airport;
import manager.airport.AirportCode;

public class POAAirport extends Airport {
    public POAAirport() {
        super(AirportCode.POA, Country.BRAZIL, City.PORTO_ALEGRE);
    }
}
