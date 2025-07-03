package com.techM.tourism_app.service;

import com.techM.tourism_app.model.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email, String password);
}
