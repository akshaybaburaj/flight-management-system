package com.flightapp.flight_service.kafka;

import com.flightapp.flight_service.entity.Passenger;
import com.flightapp.flight_service.event.BookingEvent;
import com.flightapp.flight_service.repository.PassengerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookingConsumer {

    @Autowired
    private PassengerRepository passengerRepository;

    @KafkaListener(topics = "booking-created", groupId = "flight-group")
    public void consume(BookingEvent event) {
        System.out.println("🔥 EVENT RECEIVED");   // ADD THIS

        System.out.println("📩 Received booking: " + event.getPnr());

        // 🔹 Convert event → entity
        Passenger passenger = new Passenger();
        passenger.setPnr(event.getPnr());
        passenger.setFirstName(event.getFirstName());
        passenger.setLastName(event.getLastName());
        passenger.setFlightNumber(event.getFlightNumber());
        passenger.setFlightDate(event.getFlightDate());

        // 🔹 Save to DB
        passengerRepository.save(passenger);

        System.out.println("✅ Passenger saved in Flight DB");
    }
}