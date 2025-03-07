package com.fleetmanagementapp.filters;

import com.fleetmanagementapp.SecurityConfig.CustomUserDetailsService;
import com.fleetmanagementapp.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Define publicly accessible endpoints
        String[] publicEndpoints = {
                "/api/v1/users/signup",
                "/api/v1/users/signin",
                "/api/v1/users",
                "/api/v1/employees",
                "/api/v1/companies",
                "/api/v1/cars",
                "/api/v1/swagger-ui.html",
                "/api/v1/car-brands",
                "/api/v1/car-body-types",
                "/api/v1/car-colors",
                "/api/v1/car-branches",
                "/api/v1/car-status",
                "/api/v1/car-models"
        };

        // Skip JWT processing for public endpoints
        String requestURI = request.getRequestURI();
        for (String publicEndpoint : publicEndpoints) {
            if (requestURI.startsWith(publicEndpoint)) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        // Get JWT token and validate
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorizationHeader.substring(7);
        String username = jwtUtils.extractUsername(token);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (jwtUtils.validateToken(token, userDetails)) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()
            );
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
