package airport;

import airport.exceptions.AirportDoesNotExistException;

public class AirportFactory {
    public Airport getAirport(AirportCode airport) throws AirportDoesNotExistException {
        if (airport.equals(AirportCode.GIG)) {
            return new GIGAirport();
        } else if (airport.equals(AirportCode.GRU)) {
            return new GRUAirport();
        } else if (airport.equals(AirportCode.REC)) {
            return new RECAirport();
        } else if (airport.equals(AirportCode.POA)) {
            return new POAAirport();
        } else if (airport.equals(AirportCode.BEL)) {
            return new BELAirport();
        } else if (airport.equals(AirportCode.BSB)) {
            return new BSBAirport();
        }

        throw new AirportDoesNotExistException("The following airport: " + airport + " does not exist.");
    }
}
