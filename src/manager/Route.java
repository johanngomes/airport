package manager;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import manager.airport.Airport;

@Getter
@EqualsAndHashCode
public class Route {
    private Airport from;
    private Airport to;

    public Route(Airport from, Airport to) {
        this.from = from;
        this.to = to;
    }
}
