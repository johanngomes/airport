package airport;

import java.time.LocalTime;

public class TravelTime {
    private LocalTime arrival;
    private LocalTime departure;

    public TravelTime(LocalTime arrival, LocalTime departure) {
        this.arrival = arrival;
        this.departure = departure;
    }
}
