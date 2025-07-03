package com.techM.tourism_app.controller;

import com.techM.tourism_app.model.User;
import com.techM.tourism_app.model.Booking;
import com.techM.tourism_app.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class DashboardController {

    @Autowired
    private UserRepository userRepository;

    // ✅ GET: Loads dashboard, stores logged-in user & previously chosen destination
    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model, Principal principal) {
        // 1. Get logged-in user's email from Spring Security
        String email = principal.getName();

        // 2. Fetch full user from DB and store in session
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            session.setAttribute("loggedInUser", user);
        }

        // 3. Get selected destination from session, if any
        String dest = (String) session.getAttribute("destination");
        model.addAttribute("selectedDestination", dest);
        model.addAttribute("booking", new Booking());

        return "dashboard";
    }

    // ✅ POST: Handles selection of favorite destination
    @PostMapping("/dashboard")
    public String saveDestination(@RequestParam("destination") String destination, Model model, HttpSession session) {
        session.setAttribute("destination", destination);
        model.addAttribute("selectedDestination", destination);
        return "dashboard";
    }
}
