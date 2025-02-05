package com.omkcodes.cab_booking.controller;
import com.omkcodes.cab_booking.model.Vehicle;
import com.omkcodes.cab_booking.service.VehicleService;
import java.util.Scanner;

public class VehicleController {
    private final VehicleService vehicleService;
    private final Scanner sc;
    public VehicleController(VehicleService vehicleService, Scanner sc) {
        this.vehicleService = vehicleService;
        this.sc = sc;
    }
    public void createVehicle() {
        Vehicle vehicle = vehicleService.createNewVehicle();
        if (vehicle != null) {
            System.out.println("Vehicle created successfully: " + vehicle);
        } else {
            System.out.println("Failed to create vehicle.");
        }
    }
    public void showAllVehicles() {
        vehicleService.showAllVehicles();
    }
}
