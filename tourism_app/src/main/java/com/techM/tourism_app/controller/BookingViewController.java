package com.techM.tourism_app.controller;

import com.techM.tourism_app.model.Booking;
import com.techM.tourism_app.model.User;
import com.techM.tourism_app.service.BookingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingViewController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/book")
    public String showBookingForm(@RequestParam("destination") String destination, Model model, HttpSession session) {
        Booking booking = new Booking();
        booking.setBookingType("Hotel"); // Default value

        session.setAttribute("destination", destination);
        model.addAttribute("booking", booking);
        model.addAttribute("selectedDestination", destination);
        return "booking";
    }

    @PostMapping("/bookings")
    public String handleBookingForm(@ModelAttribute("booking") Booking booking, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            return "redirect:/login";
        }

        booking.setUser(user);
        bookingService.createBooking(booking);
        return "redirect:/bookings/success";
    }

    @GetMapping("/bookings/success")
    public String showBookingSuccess() {
        return "booking_success";
    }
}
