package com.FirstJava;

import java.time.LocalDate;

public class Ticket {

    private Flight flight;
    private SeatClass classType;
    private User userName;
    private LocalDate departureDate;

    public Ticket(Flight flight, SeatClass classType,User userName, LocalDate departureDate) {
        this.flight = flight;
        this.classType = classType;
        this.userName = userName;
        this.departureDate = departureDate;
    }

    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public SeatClass getClassType() {
        return classType;
    }
    public void setClassType(SeatClass classType) {
        this.classType = classType;
    }

    public User getUserName() {
        return userName;
    }
    public void setUserName(User userName) {
        this.userName = userName;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }



}
