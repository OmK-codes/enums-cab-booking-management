package com.omkcodes.cab_booking.controller;
import com.omkcodes.cab_booking.model.Booking;
import com.omkcodes.cab_booking.service.BookingService;
import java.util.Scanner;

public class BookingController {
    private final BookingService bookingService;
    private final Scanner sc;
    public BookingController(BookingService bookingService, Scanner sc) {
        this.bookingService = bookingService;
        this.sc = sc;
    }
    public void createBooking() {
        Booking booking = bookingService.createNewBooking();
        if (booking != null) {
            System.out.println("Booking created successfully: " + booking);
        } else {
            System.out.println("Failed to create booking.");
        }
    }
    public void showAllBookings() {
        bookingService.showAllBookings();
    }
}