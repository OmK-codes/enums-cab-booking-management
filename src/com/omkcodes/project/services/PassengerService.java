package com.omkcodes.project.services;

import com.omkcodes.project.model.Passenger;
import com.omkcodes.project.enums.PassengerStatus;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PassengerService {

    private final HashMap<String, Passenger> passengerList = new HashMap<>();
    private final Scanner is = new Scanner(System.in);

    void displayPassengerDetails(Passenger passenger) {
        if (passenger != null) {
            System.out.println(passenger);
        } else {
            System.out.println("Passenger details are not available.");
        }
    }

    public Passenger createNewPassenger() {
        Passenger passenger = new Passenger();
        try {
            // Ask for and capture passenger ID (converting the input to an integer)
            System.out.println("Please Enter Passenger ID :");
            int passengerId = Integer.parseInt(is.nextLine());

            // Ask for and capture passenger's full name
            System.out.println("Enter your full Name:");
            String passengerName = is.nextLine();

            // Ask for and capture passenger's email
            System.out.println("Enter your email:");
            String email = is.nextLine();

            // Ask for and capture phone number (converting the input to an integer)
            System.out.println("Enter your Phone Number :");
            int phoneNumber = Integer.parseInt(is.nextLine());

            // Ask for and capture passenger's address
            System.out.println("Enter your Address :");
            String passengerAddress = is.nextLine();

            // Ask for and capture passenger status
            System.out.println("Enter Passenger Status (ACTIVE, INACTIVE, BLOCKED):");
            String statusInput = is.nextLine().toUpperCase();

            // Set default status to ACTIVE if the input is invalid
            PassengerStatus passengerStatus = PassengerStatus.ACTIVE;  // Default value
            try {
                passengerStatus = PassengerStatus.valueOf(statusInput);
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid passenger status! Setting default to ACTIVE.");
            }

            // Set the values for the Passenger object using setter methods
            passenger.setPassengerId(String.valueOf(passengerId));  // Store passengerId as a String
            passenger.setPassengerName(passengerName);
            passenger.setEmail(email);
            passenger.setPhone(String.valueOf(phoneNumber));
            passenger.setAddress(passengerAddress);
            passenger.setPassengerStatus(passengerStatus);  // Set passenger status

            // Adding the new passenger to the list
            passengerList.put(passenger.getPassengerId(), passenger);

        } catch (NumberFormatException e) {
            System.err.println("Invalid input! Please enter a valid numeric value for passenger ID and phone number.");
        } catch (InputMismatchException e) {
            System.err.println("Invalid input! Please ensure all inputs are correct.");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
        return passenger;
    }

    public void showAllPassengers() {
        if (passengerList.isEmpty()) {
            System.out.println("No passengers available.");
            return;
        }
        try {
            for (Passenger passenger : passengerList.values()) {
                System.out.println("Passenger Information: " + passenger);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while displaying passengers: " + e.getMessage());
        }
    }

    public HashMap<String, Passenger> getPassengerList() {
        return passengerList;
    }
}
