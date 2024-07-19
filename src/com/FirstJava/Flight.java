package com.FirstJava;

public class Flight {

    private String airlineName;
    private String fromCity;
    private String toCity;
    private String departureTime;
    private String arrivalTime;
    private int price;

    public Flight(String airlineName, String fromCity, String toCity, String departureTime, String arrivalTime, int price) {
        this.airlineName = airlineName;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }

    public String getAirlineName() {
        return airlineName;
    }
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getFromCity() {
        return fromCity;
    }
    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }
    public void setToCity(String toCity) {
        this.toCity = toCity;
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

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }






}
