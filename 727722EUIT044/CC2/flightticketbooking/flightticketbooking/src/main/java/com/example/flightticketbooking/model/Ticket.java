package com.example.flightticketbooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;

// import org.hibernate.annotations.Cascade;
// import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ticketDetail")
public class Ticket
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long passengerId;
    private Long ticketNumber;
    private String flightNumber;
    private String departureAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;
    private double price;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="User_id")
private User user;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Long getPassengerId() {
    return passengerId;
}

public void setPassengerId(Long passengerId) {
    this.passengerId = passengerId;
}

public Long getTicketNumber() {
    return ticketNumber;
}

public void setTicketNumber(Long ticketNumber) {
    this.ticketNumber = ticketNumber;
}

public String getFlightNumber() {
    return flightNumber;
}

public void setFlightNumber(String flightNumber) {
    this.flightNumber = flightNumber;
}

public String getDepartureAirport() {
    return departureAirport;
}

public void setDepartureAirport(String departureAirport) {
    this.departureAirport = departureAirport;
}

public String getArrivalAirport() {
    return arrivalAirport;
}

public void setArrivalAirport(String arrivalAirport) {
    this.arrivalAirport = arrivalAirport;
}

public String getDepartureTime() {
    return departureTime;
}

public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
}

public String getArrivalTime() {
    return arrivalTime;
}

public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
}

public double getPrice() {
    return price;
}

public void setPrice(double price) {
    this.price = price;
}

public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}

}