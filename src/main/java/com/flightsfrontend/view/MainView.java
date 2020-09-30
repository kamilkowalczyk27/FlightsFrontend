package com.flightsfrontend.view;

import com.flightsfrontend.flight.Flight;
import com.flightsfrontend.flight.FlightService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private FlightService flightService = FlightService.getInstance();
    private Grid<Flight> grid = new Grid<>(Flight.class);
    private TextField filter = new TextField();

    public MainView() {
        filter.setPlaceholder("Filter by departure...");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> update());

        grid.setColumns("departure", "arrival", "timeOfFlight", "type");
        add(filter, grid);
        setSizeFull();
    }

    private void update() {
        grid.setItems(flightService.findByDeparture(filter.getValue()));
    }

    public void refresh() {
        grid.setItems(flightService.getFlights());
    }
}
