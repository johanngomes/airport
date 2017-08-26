package airport;

import airport.exceptions.AirportDoesNotExistException;

public class AirportFactory {
    public Airport getAirport(AirportCode airport) throws AirportDoesNotExistException {
        if (airport.equals(AirportCode.GIG)) {
            return new GIGAirport();
        } else if (airport.equals(AirportCode.GRU)) {
            return new GRUAirport();
        }

        throw new AirportDoesNotExistException("The following airport: " + airport + " does not exist.");
    }
}
