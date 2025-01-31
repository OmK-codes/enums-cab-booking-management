package com.omkcodes.project.model;

import com.omkcodes.project.enums.VehicleType;
import com.omkcodes.project.enums.VehicleStatus;

public class Vehicle {
    private String vehicleId;
    private VehicleType type;
    private VehicleStatus status;
    private String model;
    private String registrationNumber;
    private String color;
    private boolean available;
    private int seatCapacity;
    private double perKmRate;

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                ", available=" + available +
                ", seatCapacity=" + seatCapacity +
                ", perKmRate=" + perKmRate +
                '}';
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public double getPerKmRate() {
        return perKmRate;
    }

    public void setPerKmRate(double perKmRate) {
        this.perKmRate = perKmRate;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return null;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
    }
}
