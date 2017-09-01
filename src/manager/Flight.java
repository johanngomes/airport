package manager;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Flight {
    private final String loc;
    private final FlightCompanies company;
    private final Route route;
    private final TravelTime travelTime;

    public Flight(String loc, FlightCompanies company, Route route, TravelTime travelTime) {
        this.loc = loc;
        this.company = company;
        this.route = route;
        this.travelTime = travelTime;
    }
}
