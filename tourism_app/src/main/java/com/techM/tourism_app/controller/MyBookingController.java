package com.techM.tourism_app.controller;

import com.techM.tourism_app.model.User;
import com.techM.tourism_app.service.BookingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyBookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/my-bookings")
    public String showBookings(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        model.addAttribute("bookings", bookingService.getBookingsByUserId(user.getId()));
        return "my_bookings";
    }
}
