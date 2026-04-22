package com.flightapp.customer_service.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.flightapp.customer_service.entity.Customer;
import com.flightapp.customer_service.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {

        // 🔹 Generate PNR (simple unique)
        String pnr = "PNR" + System.currentTimeMillis();

        customer.setPnr(pnr);

        return customerRepository.save(customer);
    }
    public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
}
}