package com.flightsfrontend.flight;

public class Flight {

    private String departure;
    private String arrival;
    private String timeOfFlight;
    private FlightType type;

    public Flight() {
    }

    public Flight(String departure, String arrival, String timeOfFlight, FlightType type) {
        this.departure = departure;
        this.arrival = arrival;
        this.timeOfFlight = timeOfFlight;
        this.type = type;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public String getTimeOfFlight() {
        return timeOfFlight;
    }

    public FlightType getType() {
        return type;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setTimeOfFlight(String timeOfFlight) {
        this.timeOfFlight = timeOfFlight;
    }

    public void setType(FlightType type) {
        this.type = type;
    }
}
