package com.techM.tourism_app.controller;

import com.techM.tourism_app.model.User;
import com.techM.tourism_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthPageController {

    @Autowired
    private UserService userService;

    // Display signup page
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup"; // loads templates/signup.html
    }

    // Handle signup form submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.registerUser(user); // save to DB
        return "redirect:/login"; // redirect to login after signup
    }

    // Display login page
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // loads templates/login.html
    }
}
