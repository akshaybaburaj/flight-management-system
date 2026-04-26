package com.flightapp.flight_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.flight_service.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, String> {

    // 🔹 Get passengers by flight
    List<Passenger> findByFlightNumber(String flightNumber);

    // 🔹 Get passengers by flight + date
    List<Passenger> findByFlightNumberAndFlightDate(String flightNumber, java.time.LocalDate flightDate);
}