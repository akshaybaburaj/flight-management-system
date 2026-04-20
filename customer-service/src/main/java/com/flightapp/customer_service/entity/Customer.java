package com.flightapp.customer_service.entity;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data; //:Lombok automatically generates getters and setters

@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customer{

    @Id
    private String pnr;

    private String firstName;
    private String lastName;
    private String gender;

    private LocalDate dateOfBirth;

    private String nationality;
    private String passportNumber;

    private String flightNumber;
    private LocalDate flightDate;

    public String getPnr() {
        return pnr;
    }
}