package com.flightapp.customer_service.event;

import java.time.LocalDate;

public class BookingEvent {

    private String pnr;
    private String firstName;
    private String lastName;
    private String flightNumber;
    private LocalDate flightDate;

    // 🔹 Constructors
    public BookingEvent() {}

    public BookingEvent(String pnr, String firstName, String lastName,
                        String flightNumber, LocalDate flightDate) {
        this.pnr = pnr;
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
    }

    // 🔹 Getters and Setters
    public String getPnr() { return pnr; }
    public void setPnr(String pnr) { this.pnr = pnr; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public LocalDate getFlightDate() { return flightDate; }
    public void setFlightDate(LocalDate flightDate) { this.flightDate = flightDate; }
}