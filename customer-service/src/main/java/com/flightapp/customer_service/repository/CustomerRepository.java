package com.flightapp.customer_service.repository;

import com.flightapp.customer_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    // 🔹 Find customer by PNR
    Customer findByPnr(String pnr);

    // 🔹 Find all customers for a flight
    java.util.List<Customer> findByFlightNumber(String flightNumber);

    // 🔹 Find by flight number + date
    java.util.List<Customer> findByFlightNumberAndFlightDate(String flightNumber, java.time.LocalDate flightDate);
}