package com.flightapp.customer_service.entity;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    private String pnr;

    private String firstName;
    private String lastName;
    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String nationality;
    private String passportNumber;

    private String flightNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate flightDate;

    // ✅ Getters & Setters

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }
}













// package com.flightapp.customer_service.entity;
// import java.time.LocalDate;

// import org.springframework.format.annotation.DateTimeFormat;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.Data; //:Lombok automatically generates getters and setters

// @Data
// @Entity
// @Table(name = "CUSTOMERS")
// public class Customer{

//     @Id
//     private String pnr;

//     private String firstName;
//     private String lastName;
//     private String gender;

//     @DateTimeFormat(pattern = "yyyy-MM-dd")
//     private LocalDate dateOfBirth;

//     private String nationality;
//     private String passportNumber;

//     private String flightNumber;
//     @DateTimeFormat(pattern = "yyyy-MM-dd")
//     private LocalDate flightDate;

//     public String getPnr() {
//         return pnr;
//     }
// public void setPnr(String pnr) {
//     this.pnr = pnr;
// }
   


// }

