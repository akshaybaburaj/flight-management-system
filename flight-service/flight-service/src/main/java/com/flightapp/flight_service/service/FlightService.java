package com.flightapp.flight_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.flight_service.entity.Flight;
import com.flightapp.flight_service.repository.FlightRepository;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);

        
    }
    public Flight findByFlightNumber(String flightNumber) {
    return flightRepository.findByFlightNumber(flightNumber);
}

public List<Flight> findByRoute(String source, String destination) {
    return flightRepository.findBySourceAndDestination(source, destination);
}
}