package com.omkcodes.cab_booking.controller;
import com.omkcodes.cab_booking.model.Driver;
import com.omkcodes.cab_booking.service.DriverService;
import java.util.Scanner;

public class DriverController {
    private final DriverService driverService;
    private final Scanner sc;
    public DriverController(DriverService driverService, Scanner sc) {
        this.driverService = driverService;
        this.sc = sc;}
    public void createDriver() {
        Driver driver = driverService.createNewDriver();
        if (driver != null) {
            System.out.println("Driver created successfully: " + driver);
        } else {
            System.out.println("Failed to create driver.");
        }
    }
    public void showAllDrivers() {
        driverService.showAllDrivers();
    }
}