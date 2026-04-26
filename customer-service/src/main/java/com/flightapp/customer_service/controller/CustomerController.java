package com.flightapp.customer_service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.flightapp.customer_service.entity.Customer;
import com.flightapp.customer_service.service.CustomerService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/create-customer")
    public String showForm() {
        return "create-customer";
    }

    @PostMapping("/save")
    public String saveCustomer(Customer customer, Model model) {

       
       // ✅ Save customer and get saved object
        Customer saved = customerService.saveCustomer(customer);
        model.addAttribute("pnr", saved.getPnr());

        // 🔹 Send ALL customers (for table)
        model.addAttribute("customers", customerService.getAllCustomers());

        return "create-customer";
    }
}