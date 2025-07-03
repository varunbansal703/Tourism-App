package com.techM.tourism_app.service;

import com.techM.tourism_app.model.Booking;

import java.util.List;

public interface BookingService {
    
    Booking createBooking(Booking booking);  // method to save a booking

    List<Booking> getBookingsByUserId(Long userId);  // retrieve all bookings of a user
}
