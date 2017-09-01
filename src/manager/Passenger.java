package manager;

import manager.exceptions.InvalidFullNameException;
import manager.exceptions.InvalidNumberOfDigitsCPFException;

public class Passenger {
    private final String cpf;
    private final String name;

    public Passenger(String cpf, String fullName) throws InvalidNumberOfDigitsCPFException, InvalidFullNameException {
        validateCPF(cpf);
        validateFullName(fullName);

        this.cpf = cpf;
        this.name = fullName;
    }

    private void validateCPF(String cpf) throws InvalidNumberOfDigitsCPFException {
        if(cpf.length() != 11) {
            throw new InvalidNumberOfDigitsCPFException("The CPF: " + cpf + " has not 11 digits.");
        }
    }

    private void validateFullName(String fullName) throws InvalidFullNameException {
        if(!fullName.contains(" ")){
            throw new InvalidFullNameException("The Full Name: " + fullName + " does not have a surname.");
        }
    }

    public Booking book(Flight flight) {
        return new Booking(this, flight);
    }
}
