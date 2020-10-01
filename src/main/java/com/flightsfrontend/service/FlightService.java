package com.flightsfrontend.service;

import com.flightsfrontend.dto.FlightDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FlightService {

    private RestTemplate restTemplate;

    public List<FlightDto> getAllFlight() throws HttpServerErrorException {
        FlightDto[] allFlightList = restTemplate.getForObject("http://localhost:8080/v1/getFlights", FlightDto[].class);
        assert allFlightList != null;
        return new ArrayList<>(Arrays.asList(allFlightList));
    }
}
