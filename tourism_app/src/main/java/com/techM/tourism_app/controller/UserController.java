package com.techM.tourism_app.controller;

import com.techM.tourism_app.model.User;
import com.techM.tourism_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // Allow frontend access (e.g., from React or other domains)
public class UserController {

    @Autowired
    private UserService userService;

    // API to handle user registration
    @PostMapping("/signup")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // API to handle user login
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.loginUser(user.getEmail(), user.getPassword());
    }
}
