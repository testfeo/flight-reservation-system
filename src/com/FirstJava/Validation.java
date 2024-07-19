package com.FirstJava;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {
    static Scanner scan = new Scanner(System.in);

    public static int intInputValidation(int max) {
        int userInput = 0;
        boolean valid = false;

        while (!valid) {
            try {
                userInput = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scan.nextLine();
                continue;
            }


            if (userInput >= 1 && userInput <= max) {
                valid = true;
            } else {
                System.out.println("Invalid choice. Please enter numbers from " + 1 + " to " + max);
            }
        }
        return userInput;
    }

    public static User UserFullNameValidation() {
        String regex = "^[A-Za-z]{1,50} [A-Za-z]{1,50}$";
        String name;

        while (true) {
            name = scan.nextLine();

            if (name == null || name.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }
            if (!name.matches(regex)) {
                System.out.println("Too many characters or invalid input. Please try again.");
                continue;
            }
            break;
        }
        return new User(name);
    }

    public static int sortFlightDays(LocalDate departureDate) {
        int result = departureDate.getDayOfMonth();
        return result % 2 == 0 ? 2 : 1;
    }
}


