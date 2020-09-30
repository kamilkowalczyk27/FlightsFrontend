package com.flightsfrontend.view;

import com.flightsfrontend.flight.Flight;
import com.flightsfrontend.flight.FlightService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class FlightView extends VerticalLayout {
    private FlightService flightService;
    private Grid<Flight> grid = new Grid<>(Flight.class);
    private TextField filter = new TextField();

    public FlightView() {
        grid.setColumns("departure", "arrival");
        add(filter, grid);
        setSizeFull();
        filter.setPlaceholder("Filter by arrival");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> update());

    }

    public void update() {
        grid.setItems(flightService.findByArrival(filter.getValue()));
    }

    public void refresh() {
        grid.setItems(flightService.getFlights());
    }
}
