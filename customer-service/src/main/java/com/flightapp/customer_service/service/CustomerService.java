package com.flightapp.customer_service.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightapp.customer_service.entity.Customer;
import com.flightapp.customer_service.event.BookingEvent;
import com.flightapp.customer_service.kafka.BookingProducer;
import com.flightapp.customer_service.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BookingProducer bookingProducer;

    public Customer saveCustomer(Customer customer) {

        // 🔹 Generate PNR (simple unique)
        String pnr = "PNR" + System.currentTimeMillis();

        customer.setPnr(pnr);

        // 🔹 Save to DB
    Customer saved = customerRepository.save(customer);

    // 🔥 CREATE EVENT
    BookingEvent event = new BookingEvent(
            saved.getPnr(),
            saved.getFirstName(),
            saved.getLastName(),
            saved.getFlightNumber(),
            saved.getFlightDate()
    );

    // 🔥 SEND TO KAFKA
    bookingProducer.sendBookingEvent(event);

    return saved;
        // return customerRepository.save(customer);
    }
    public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
}
}