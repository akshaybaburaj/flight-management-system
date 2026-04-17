package com.flightapp.flight_service.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.flightapp.flight_service.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
// 👉 Marks this filter as Spring-managed component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;
    // 👉 Inject JwtUtil to validate token

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // 👉 Get Authorization header
        // 🔹 Get token from header
String header = request.getHeader("Authorization");

// 🔹 Get token from URL (NEW)
String tokenParam = request.getParameter("token");

String token = null;

// 👉 Priority: Header first, then URL
if (header != null && header.startsWith("Bearer ")) {
    token = header.substring(7);
} else if (tokenParam != null) {
    token = tokenParam;
} else {
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.getWriter().write("Missing Token");
    return;
}

// 🔹 Validate token
    if (!jwtUtil.validateToken(token)) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Invalid JWT Token");
        return;
    }

    // 🔹 Extract username
    String username = jwtUtil.extractUsername(token);

    // 🔹 Store in request
    request.setAttribute("username", username);

    // 🔹 Continue request
    filterChain.doFilter(request, response);
}
}