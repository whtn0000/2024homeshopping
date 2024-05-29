package com.example.ps.service;

import com.example.ps.domain.User;

public interface UserService {
    User registerUser(User user);
    String loginUser(String username, String password);
    User changePassword(String username, String oldPassword, String newPassword);
}
