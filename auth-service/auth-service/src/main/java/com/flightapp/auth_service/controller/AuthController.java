package com.flightapp.auth_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightapp.auth_service.service.AuthService;
import com.flightapp.auth_service.util.JwtUtil;
@Controller
@RequestMapping("/auth")

public class AuthController {
@Autowired
public AuthService authService;

@Autowired //for injecting token
private JwtUtil jwtUtil;

@GetMapping("/login") // To first display the login page
public String showLoginPage()
{
    return "login";
}
@GetMapping("/home") //to redirect to auth/home when the password is correct. Intercepts return "redirect:home" \
//RequestParam is an annotation in Spring Boot (Spring MVC) used to read data from the URL query parameters or form data and bind it to a method parameter in your controller.
public String showHomePage(@RequestParam String username, @RequestParam String token, Model model)
{
    model.addAttribute("username", username);
    model.addAttribute("token", token);
    return "home";
}

@PostMapping("/login") //this intercepts the form action of login button, gets the creds and pass to service to check in DB
public String login(@RequestParam String username, @RequestParam String password, Model model)
{
boolean isValid = authService.login(username,password);

if(isValid)
{
    // 🔥 Generate JWT
        String token = jwtUtil.generateToken(username);

        // model.addAttribute("username", username);
        // model.addAttribute("token", token); // send to UI
        // 🔥 pass data via URL
        return "redirect:/auth/home?username=" +username+ "&token=" + token; //home.html gets token

}
//model.addAttribute("error", "Invalid Credentials");
return "redirect:/auth/login?error=true";
}
}
