package manager;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BookingRepository {
    List<Booking> bookings = new ArrayList<>();

    public void add(Booking booking) {
        bookings.add(booking);
    }
}
