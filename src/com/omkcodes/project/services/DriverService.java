package com.omkcodes.project.services;

import com.omkcodes.project.model.Driver;
import com.omkcodes.project.enums.DriverStatus;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DriverService {

    private final HashMap<String, Driver> driverList = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    void displayDriverDetails(Driver driver) {
        if (driver != null) {
            System.out.println(driver);
        } else {
            System.out.println("Driver details are not available.");
        }
    }

    public Driver createNewDriver() {
        Driver driver = new Driver();
        try {
            System.out.println("Please Enter Driver ID :");
            String driverId = sc.nextLine();

            System.out.println("Enter the Driver Name:");
            String driverName = sc.nextLine();

            System.out.println("Enter the Driver Phone Number:");
            String phone = sc.nextLine();

            System.out.println("Enter the Driver License Number:");
            String licenseNumber = sc.nextLine();

            System.out.println("Enter the Total Trips Made by the Driver:");
            int totalTrips = Integer.parseInt(sc.nextLine());

            System.out.println("Is the driver online? (true/false):");
            boolean onlineStatus = Boolean.parseBoolean(sc.nextLine());

            System.out.println("Enter Driver Status (ACTIVE, INACTIVE, BLOCKED, SUSPENDED):");
            String statusInput = sc.nextLine().toUpperCase();

            DriverStatus driverStatus = DriverStatus.INACTIVE;
            try {
                driverStatus = DriverStatus.valueOf(statusInput);
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid driver status! Setting default to ACTIVE.");
            }

            driver.setDriverId(driverId);
            driver.setDriverName(driverName);
            driver.setPhone(phone);
            driver.setLicenseNumber(licenseNumber);
            driver.setTotalTrips(totalTrips);
            driver.setOnlineStatus(onlineStatus);
            driver.setDriverStatus(driverStatus);

            driverList.put(driver.getDriverId(), driver);

        } catch (NumberFormatException e) {
            System.err.println("Invalid input! Please enter a valid numeric value for total trips.");
        } catch (InputMismatchException e) {
            System.err.println("Invalid input! Please ensure all inputs are correct.");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
        return driver;
    }

    public void showAllDrivers() {
        if (driverList.isEmpty()) {
            System.out.println("No drivers available.");
            return;
        }
        try {
            for (Driver driver : driverList.values()) {
                System.out.println("Driver Information: " + driver);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while displaying drivers: " + e.getMessage());
        }
    }

    public HashMap<String, Driver> getDriverList() {
        return driverList;
    }
}
