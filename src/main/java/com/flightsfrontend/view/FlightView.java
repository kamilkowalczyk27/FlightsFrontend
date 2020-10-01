package com.flightsfrontend.view;

import com.flightsfrontend.dto.FlightDto;
import com.flightsfrontend.service.FlightService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route("flightView")
public class FlightView extends VerticalLayout {

    private FlightService flightService = new FlightService();
    private Grid<FlightDto> grid = new Grid<>(FlightDto.class);

    public FlightView() {

        grid.setColumns("id", "departure", "arrival", "timeOfFlight");
        add(grid);
        setSizeFull();
    }

    public void refresh() {
        grid.setItems(flightService.getAllFlight());
    }
}
