import com.omkcodes.project.model.Booking;
import com.omkcodes.project.model.Driver;
import com.omkcodes.project.model.Passenger;
import com.omkcodes.project.model.Vehicle;
import com.omkcodes.project.services.BookingService;
import com.omkcodes.project.services.DriverService;
import com.omkcodes.project.services.PassengerService;
import com.omkcodes.project.services.VehicleService;

import java.util.Scanner;

public class CabBookingManagement {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;

        // Created service
        DriverService driverService = new DriverService();
        PassengerService passengerService = new PassengerService();
        VehicleService vehicleService = new VehicleService();
        BookingService bookingService = new BookingService();

        do {
            System.out.println("\n--- Cab Booking Management System ---");
            System.out.println("1. Create Passenger");
            System.out.println("2. Create Driver");
            System.out.println("3. Create Vehicle");
            System.out.println("4. Create Booking");
            System.out.println("5. Show All Passengers");
            System.out.println("6. Show All Drivers");
            System.out.println("7. Show All Vehicles");
            System.out.println("8. Show All Bookings");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    Passenger passenger = passengerService.createNewPassenger();
                    passengerService.getPassengerList().put(passenger.getPassengerId(), passenger);
                    System.out.println("Passenger created: " + passenger);
                    break;

                case 2:
                    Driver driver = driverService.createNewDriver();
                    driverService.getDriverList().put(driver.getDriverId(), driver);
                    System.out.println("Driver created: " + driver);
                    break;

                case 3:
                    Vehicle vehicle = vehicleService.createNewVehicle();
                    vehicleService.getVehicleList().put(vehicle.getVehicleId(), vehicle);
                    System.out.println("Vehicle created: " + vehicle);
                    break;

                case 4:
                    // Collect necessary details for booking
                    System.out.println("Enter Booking ID:");
                    String bookingId = sc.nextLine();
                    System.out.println("Enter Driver ID:");
                    String driverId = sc.nextLine();
                    System.out.println("Enter Passenger ID:");
                    String passengerId = sc.nextLine();
                    System.out.println("Enter Vehicle ID:");
                    String vehicleId = sc.nextLine();

                    // Check if the driver, passenger, and vehicle exist
                    if (driverService.getDriverList().containsKey(driverId) &&
                            passengerService.getPassengerList().containsKey(passengerId) &&
                            vehicleService.getVehicleList().containsKey(vehicleId)) {

                        // Create the booking
                        Booking booking = bookingService.createNewBooking();
                        booking.setBookingId(bookingId);
                        booking.setDriverId(driverId);
                        booking.setPassengerId(passengerId);
                        booking.setVehicleId(vehicleId);

                        // Store the booking using bookingId as the key
                        bookingService.getBookingList().put(bookingId, booking);
                        System.out.println("Booking created: " + booking);
                    } else {
                        System.out.println("Error: Invalid Driver ID, Passenger ID, or Vehicle ID.");
                    }
                    break;

                case 5:
                    passengerService.showAllPassengers();
                    break;

                case 6:
                    driverService.showAllDrivers();
                    break;

                case 7:
                    vehicleService.showAllVehicles();
                    break;

                case 8:
                    bookingService.showAllBookings();
                    break;

                case 0:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        } while (option != 0);
        System.out.println("KEEP TRAVELLING!");
    }
}
