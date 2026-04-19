package com.flightapp.flight_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.flight_service.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    // 🔹 Search by flight number
    Flight findByFlightNumber(String flightNumber);

    // 🔹 Search by route
    List<Flight> findBySourceAndDestination(String source, String destination);

    // 🔹 Search by route + date (advanced)
    List<Flight> findBySourceAndDestinationAndFlightDate(String source, String destination, String flightDate);

   List<Flight> findByFlightNumberAndFlightDate(String flightNumber,String flightDate);
}