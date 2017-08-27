package airport;

public class Passenger {
    private final String cpf;
    private final String name;

    public Passenger(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public Booking book(Flight flight) {
        return new Booking(this, flight);
    }
}
