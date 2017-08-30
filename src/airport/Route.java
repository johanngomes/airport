package airport;

import lombok.EqualsAndHashCode;
import lombok.Getter;

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
