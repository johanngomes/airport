package manager;

public class Passenger {
    private final String CPF;
    private final String name;

    //default constructor
    public Passenger(String CPF, String fName) throws Exception {
        //check if the lenght of CPF is 11
        if(CPF.length() != 11) {
            throw new Exception();
        }

        if(!fName.contains(" ")){
            throw new Exception();
        }

        this.CPF = CPF;
        this.name = fName;
    }

    public Booking book(Flight flight) {
        return new Booking(this, flight);
    }
}
