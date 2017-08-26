package airport.exceptions;

public class AirportDoesNotExistException extends Exception {
    public AirportDoesNotExistException(String message) {
        super(message);
    }
}
