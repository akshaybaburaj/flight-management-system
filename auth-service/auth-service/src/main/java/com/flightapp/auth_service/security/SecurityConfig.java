package com.flightapp.auth_service.security;
// This tells Java where this file is located

import org.springframework.context.annotation.Bean;
// Used to tell Spring: "create and manage this object"

import org.springframework.context.annotation.Configuration;
// Marks this class as a configuration class

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// Used to configure security rules

import org.springframework.security.web.SecurityFilterChain;
// Represents the chain of security rules

@Configuration
// This tells Spring: "This class contains configuration settings"
public class SecurityConfig {

    @Bean
    // This tells Spring: "Create this method's return object and manage it"
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // 🔹 Disable CSRF protection
            // CSRF is a security feature, but for now it blocks our simple forms
            // So we turn it OFF to make things easy
            .csrf(csrf -> csrf.disable())

            // 🔹 Define which requests are allowed
            .authorizeHttpRequests(auth -> auth
                // Allow ALL requests without login (no restriction)
                .anyRequest().permitAll()
            )

            // 🔹 Disable Spring's default login page
            // Otherwise it will redirect to /login automatically
            .formLogin(form -> form.disable());

        // Return the configured security rules
        return http.build();
    }
}