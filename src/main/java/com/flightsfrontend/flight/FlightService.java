package com.flightsfrontend.flight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private List<Flight> flights;

    public List getFlights() {
        return new ArrayList(flights);
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    private List<Flight> flights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Moscow", "Berlin"));
        flights.add(new Flight("London", "Madrid"));
        return flights;
    }

    public List<Flight> findByArrival(String arrival) {
        return flights.stream().filter(flight -> flight.getArrival().contains(arrival)).collect(Collectors.toList());
    }
}





