package com.flightapp.customer_service.kafka;

import com.flightapp.customer_service.event.BookingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingProducer {

    @Autowired
    private KafkaTemplate<String, BookingEvent> kafkaTemplate;

    private static final String TOPIC = "booking-created";

    public void sendBookingEvent(BookingEvent event) {

        kafkaTemplate.send(TOPIC, event);

        System.out.println("✅ Sent booking event to Kafka: " + event.getPnr());
    }
}