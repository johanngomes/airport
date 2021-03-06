package manager.seeds;

import manager.airport.AirportCode;
import manager.airport.AirportFactory;
import manager.Flight;
import manager.FlightCompany;
import manager.FlightRepository;
import manager.Route;
import manager.TravelTime;
import manager.exceptions.AirportDoesNotExistException;

import java.time.LocalTime;

public class FlightRepositorySeed {
    private static final FlightRepository flightRepository = new FlightRepository();
    private static final AirportFactory airportFactory = new AirportFactory();

    public static void populate() throws AirportDoesNotExistException {
        createRecToSp();
        createSpToPoa();
        createRecToRj();
        createRjToBsb();
        createBsbToBel();
    }

    private static void createBsbToBel() throws AirportDoesNotExistException {
        String loc = "MADAAW";
        FlightCompany company = FlightCompany.GOL;
        Route route = new Route(airportFactory.getAirport(AirportCode.BSB), airportFactory.getAirport(AirportCode.BEL));
        TravelTime travelTime = new TravelTime(LocalTime.of(13, 30), LocalTime.of(15, 20));
        Flight flight = new Flight(loc, company, route, travelTime);

        flightRepository.add(flight);
    }

    private static void createRjToBsb() throws AirportDoesNotExistException {
        String loc = "JWADMV";
        FlightCompany company = FlightCompany.LATAM;
        Route route = new Route(airportFactory.getAirport(AirportCode.GIG), airportFactory.getAirport(AirportCode.BSB));
        TravelTime travelTime = new TravelTime(LocalTime.of(13, 30), LocalTime.of(15, 20));
        Flight flight = new Flight(loc, company, route, travelTime);

        flightRepository.add(flight);
    }

    private static void createRecToRj() throws AirportDoesNotExistException {
        String loc = "MCAKKL";
        FlightCompany company = FlightCompany.LATAM;
        Route route = new Route(airportFactory.getAirport(AirportCode.REC), airportFactory.getAirport(AirportCode.GIG));
        TravelTime travelTime = new TravelTime(LocalTime.of(9, 30), LocalTime.of(10, 30));
        Flight flight = new Flight(loc, company, route, travelTime);

        flightRepository.add(flight);
    }

    private static void createSpToPoa() throws AirportDoesNotExistException {
        String loc = "KAAVRO";
        FlightCompany company = FlightCompany.GOL;
        Route route = new Route(airportFactory.getAirport(AirportCode.GRU), airportFactory.getAirport(AirportCode.POA));
        TravelTime travelTime = new TravelTime(LocalTime.of(13, 30), LocalTime.of(15, 20));
        Flight flight = new Flight(loc, company, route, travelTime);

        flightRepository.add(flight);
    }

    private static void createRecToSp() throws AirportDoesNotExistException {
        String loc = "KSTVWO";
        FlightCompany company = FlightCompany.GOL;
        Route route = new Route(airportFactory.getAirport(AirportCode.REC), airportFactory.getAirport(AirportCode.GRU));
        TravelTime travelTime = new TravelTime(LocalTime.of(11, 00), LocalTime.of(13, 00));
        Flight flight = new Flight(loc, company, route, travelTime);

        flightRepository.add(flight);
    }
}
