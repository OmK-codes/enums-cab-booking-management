package com.omkcodes.cab_booking.controller;
import com.omkcodes.cab_booking.model.Passenger;
import com.omkcodes.cab_booking.service.PassengerService;
import java.util.Scanner;

public class PassengerController {
    private final PassengerService passengerService;
    private final Scanner sc;
    public PassengerController(PassengerService passengerService, Scanner sc) {
        this.passengerService = passengerService;
        this.sc = sc;}
    public void createPassenger() {
        Passenger passenger = passengerService.createNewPassenger();
        if (passenger != null) {
            System.out.println("Passenger created: " + passenger);
        } else {
            System.out.println("Failed to create passenger.");
        }
    }
    public void showAllPassengers() {
        passengerService.showAllPassengers();
    }
}
