package com.flightapp.flight_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.flightapp.flight_service.entity.Flight;
import com.flightapp.flight_service.service.FlightService;

import jakarta.servlet.http.HttpServletRequest;

@Controller

public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/flight/identify-customer")
    public String identifyCustomer(HttpServletRequest request, Model model) {

        // 👉 Get username from filter
        String username = (String) request.getAttribute("username");

        model.addAttribute("username", username);
        String token = request.getParameter("token");
        model.addAttribute("token", token);

        return "identify-customer";
    }

    @GetMapping("/flight/identify-flight")
    public String identifyFlight(HttpServletRequest request, Model model) {

        String username = (String) request.getAttribute("username");// The username is set in the JwtFilter using
                                                                    // request.setAttribute() and later retrieved in the
                                                                    // controller from the same request object.

        model.addAttribute("username", username);
        // To ensure token is available in all pages
        String token = request.getParameter("token");
        model.addAttribute("token", token);

        // 🔹 Get search inputs
        String flightNumber = request.getParameter("q");
        String source = request.getParameter("from");
        String destination = request.getParameter("to");
        String flightDate = request.getParameter("date");

        // 🔹 Search logic (ADD HERE)
        if (flightNumber != null && !flightNumber.isEmpty() &&
                flightDate != null && !flightDate.isEmpty()) {

            List<Flight> flight = flightService.findByFlightNumberAndFlightDate(flightNumber, flightDate);

            if (flight == null) {
                model.addAttribute("message", "No result found");
            } else {
                model.addAttribute("flight", flight);
            }
        }

        // 🔹 Search by flight number
        else if (flightNumber != null && !flightNumber.isEmpty()) {
            Flight flight = flightService.findByFlightNumber(flightNumber);

            if (flight == null)
                model.addAttribute("message", "No Flights found");
            else {
                model.addAttribute("flight", flight);
                 }

        }

        // 🔹 Search by route - multiple flights
        else if (source != null && destination != null &&
                !source.isEmpty() && !destination.isEmpty()) {

            model.addAttribute("flights",
                    flightService.findByRoute(source, destination));// multiple flights
        }

        return "identify-flight";
    }

    @GetMapping("/flight/add-flight")
    public String addFlight(HttpServletRequest request, Model model) {

        String username = (String) request.getAttribute("username");// The username is set in the JwtFilter using
                                                                    // request.setAttribute() and later retrieved in the
                                                                    // controller from the same request object.

        model.addAttribute("username", username);
        // To ensure token is available in all pages
        String token = request.getParameter("token");
        model.addAttribute("token", token);

        return "add-flight";
    }

    @PostMapping("/flight/add-flight/save")
    public String saveFlight(Flight flight, HttpServletRequest request) {

        // 👉 Save to DB
        flightService.saveFlight(flight);

        // 👉 Get token (to preserve login)
        String token = request.getParameter("token");
        String flightDate = request.getParameter("flightDate");

        // 👉 Redirect back to add page
        return "redirect:/flight/add-flight?token=" + token;
    }
}
