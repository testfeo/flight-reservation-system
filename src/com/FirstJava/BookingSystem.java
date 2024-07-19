package com.FirstJava;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BookingSystem {
    private Database database;
    private Scanner scanner;

    public BookingSystem() {
        database = new Database();
        scanner = new Scanner(System.in);
    }

    public void startBookingProcess() {
        System.out.println("Welcome to the Flight Booking System!");

        String fromCity = selectDepartureCity();
        String toCity = selectDestinationCity(fromCity);
        LocalDate departureDate = enterDepartureDate();
        List<Flight> availableFlights = database.getAvailableFlights(fromCity, toCity, departureDate);
        Flight selectedFlight = selectFlight(availableFlights, departureDate);
        SeatClass classType = selectClassType(selectedFlight);
        User passengerName = addPassengerName();
        Ticket ticket = new Ticket(selectedFlight, classType, passengerName, departureDate);

        System.out.println("----Your ticket has been booked successfully!----");
    }

    private String selectDepartureCity() {
        List<String> departureList = database.getDepartureCities();

        ConsoleUI.showDepartureCity(departureList);

        int departureUserChoice = Validation.intInputValidation(departureList.size());
        String targetDeparture = departureList.get(departureUserChoice - 1);

        System.out.println("From: " + targetDeparture);
        System.out.println();

        return targetDeparture;
    }

    private String selectDestinationCity(String fromCity) {
        List<String> destinationList = database.getDestinationCities(fromCity);

        ConsoleUI.showDestinationCity(destinationList);

        int destinationUserChoice = Validation.intInputValidation(destinationList.size());
        String targetDestination = destinationList.get(destinationUserChoice - 1);

        System.out.println("To: " + targetDestination);
        System.out.println();
        return targetDestination;
    }

    private LocalDate enterDepartureDate() {
        System.out.println("SELECT DATE: \n " +
                "-enter month [1-12]-");

        int month = Validation.intInputValidation(12);
        YearMonth yearMonth = YearMonth.of(2024, month);

        ConsoleUI.showCalendar(yearMonth);
        int day = Validation.intInputValidation(31);

        return LocalDate.of(2024,month,day);
    }

    private Flight selectFlight(List<Flight> availableFlights, LocalDate departureDate) {

        ConsoleUI.showAvailableFlights(availableFlights,departureDate);

        int flightIndex = Validation.intInputValidation(availableFlights.size());

        return availableFlights.get(flightIndex -1);
    }

    private SeatClass selectClassType(Flight selectedFlight) {

        ConsoleUI.showSeatClass(selectedFlight);

        HashMap<Integer, SeatClass> seatClassMap = new HashMap<>();
        seatClassMap.put(1, SeatClass.FIRST);
        seatClassMap.put(2, SeatClass.BUSINESS);
        seatClassMap.put(3, SeatClass.ECONOMY);

        return seatClassMap.get(Validation.intInputValidation(seatClassMap.size()));
    }

    private User addPassengerName() {
        System.out.println("PASSENGER \n" +
                "-enter your full name-");

        User user = Validation.UserFullNameValidation();
        database.uploadUserToDatabase(user);

        return user;
    }

}
