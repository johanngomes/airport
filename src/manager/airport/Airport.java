package manager.airport;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import manager.City;
import manager.Country;

@Getter
@EqualsAndHashCode
public class Airport {
    private AirportCode airportCode;
    private Country country;
    private City city;

    public Airport(AirportCode airportCode, Country country, City city) {
        this.airportCode = airportCode;
        this.country = country;
        this.city = city;
    }
}
