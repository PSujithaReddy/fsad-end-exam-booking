package com.klef.fsad.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // 1. Add Booking
    @PostMapping("/add")
    public ResponseEntity<String> addBooking(@RequestBody Booking booking) {
        if (booking.getBookingId() == null) {
            return ResponseEntity.badRequest().body("Error: Booking ID MUST be provided manually and cannot be null.");
        }
        bookingService.addBooking(booking);
        return ResponseEntity.ok("Booking added successfully with ID: " + booking.getBookingId());
    }

    // 2. Delete Booking
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted successfully.");
    }
}
