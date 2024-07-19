package com.FirstJava;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class ConsoleUI {

    public static void showDepartureCity (List<String> departureCity) {

        System.out.println(
                "----------------------------- SEARCH FLIGHTS -----------------------------");
        System.out.println();
        System.out.println("WHERE ARE YOU TRAVELLING FROM? \n " +
                "-inter a number of departure city-");
        System.out.println();

        for (int i = 0; i < departureCity.size(); i++) {
            System.out.println((i + 1) + ". " + departureCity.get(i));
        }
        System.out.println();
    }


    public static void showDestinationCity (List<String> cities) {

        System.out.println("WHERE DO YOU WANT TO GO? \n " +
                "-inter a number of destination city-");
        System.out.println();

        for (int i = 0; i < cities.size(); i++) {
            System.out.println(i + 1 + "." + cities.get(i));
        }
    }


    public static void showCalendar(YearMonth yearMonth ) {

        System.out.println(yearMonth.getMonth().toString() + " 2024");
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        LocalDate firstDay = yearMonth.atDay(1);
        int offset = firstDay.getDayOfWeek().getValue() % 7;

        for (int i = 0; i < offset; i++) {
            System.out.print("    ");
        }

        for (int i = 1; i <= yearMonth.lengthOfMonth(); i++) {
            LocalDate currentDate = yearMonth.atDay(i);
            String day = String.format("%2d", i);

            //format
            if (currentDate.equals(LocalDate.now())) {
                System.out.print("\033[1m" + day + "\033[0m");
            } else {
                System.out.print(day);
            }
            System.out.print(" ");

            if (currentDate.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("ENTER NUMBER OF DAY");
    }


    public static void showAvailableFlights(List<Flight> availableFlights, LocalDate departureDate  ) {

        System.out.println(
                "-----------------------------  FLIGHT RESULTS -----------------------------");
        System.out.println(departureDate.getDayOfMonth() + " " + departureDate.getMonth() +  " " + departureDate.getYear());
        System.out.println();

        if (!availableFlights.isEmpty()) {
            int counter = 1;
            for (Flight flight : availableFlights) {
                System.out.println(counter + ". " + flight.getAirlineName() + ": " + flight.getFromCity() +
                        "[" + flight.getDepartureTime() + "]  ->  " + flight.getToCity() +
                        "[" + flight.getArrivalTime() + "]\n PRICE from:" + flight.getPrice() + " EURO");
                System.out.println();
                counter++;
            }
        } else System.out.println("Unfortunately, no flights were found for the selected date. Try other dates.");
    }


    public static void showSeatClass(Flight selectedFlight) {

        System.out.println("-Select class type-");

        //FIRST
        System.out.println("1." + "FIRST CLASS \n " +
                "PRICE:" + (selectedFlight.getPrice() + 50) + " EUR");
        System.out.println();

        //BUSINESS
        System.out.println("2." + "BUSINESS CLASS \n " +
                "PRICE:" + (selectedFlight.getPrice() + 30) + " EUR");
        System.out.println();


        //ECONOMY
        System.out.println("3." + "ECONOMY CLASS \n " +
                "PRICE:" + selectedFlight.getPrice() + " EUR");
        System.out.println();
        System.out.println("|enter a number of class|");
    }
}


