package com.flightsfrontend.flight;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightService {

    private Set<Flight> flights;
    private static FlightService flightService;

    private FlightService() {
        this.flights = exampleFlight();
    }

    public static FlightService getInstance() {
        if (flightService == null) {
            flightService = new FlightService();
        }
        return flightService;
    }

    public Set<Flight> getFlights() {
        return new HashSet<>(flights);
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    private Set exampleFlight() {
        Set books = new HashSet<>();
        books.add(new Flight("London", "Berlin",  "2.00", FlightType.Airbus));
        books.add(new Flight("Moscow", "Madrid", "4.00", FlightType.Airbus));
        books.add(new Flight("Barcelona", "London", "3.00", FlightType.Boeing));
        books.add(new Flight("London", "Rome", "2.00", FlightType.Boeing));
        books.add(new Flight("Warsaw", "Berlin", "1.30", FlightType.Airbus));
        books.add(new Flight("Paris", "Rome", "1.30", FlightType.Boeing));
        books.add(new Flight("Warsaw", "Basel", "2.00", FlightType.Boeing));
        return books;
    }

    public Set findByDeparture(String departure) {
        return flights.stream().filter(flight -> flight.getDeparture().contains(departure)).collect(Collectors.toSet());
    }
}
