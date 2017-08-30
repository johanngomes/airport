package airport;

import lombok.EqualsAndHashCode;
import lombok.Getter;

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
