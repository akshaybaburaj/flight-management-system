package com.flightapp.auth_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.auth_service.entity.User;
import com.flightapp.auth_service.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    public UserRepository userRepository;

    public boolean login(String username, String password) {
        // 🔍 Step 1: Fetch user from DB
        User user = userRepository.findByUsername(username).orElse(null);
        System.out.println("User from DB: " + user);
       
        if (user!=null && user.getPassword().equals(password))
        {
            return true;
        }
        return false;
        }
    }
