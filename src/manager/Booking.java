package manager;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Booking {
    private final Passenger passenger;
    private final Flight flight;
    private final boolean checkedIn;

    public Booking(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
        this.checkedIn = false;
    }
}
