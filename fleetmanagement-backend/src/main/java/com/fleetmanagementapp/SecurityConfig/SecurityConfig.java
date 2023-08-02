package com.fleetmanagementapp.SecurityConfig;


import com.fleetmanagementapp.filters.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        HttpSecurity httpSecurity = http
                //Cross-origin-resource-sharing: localhost:8080, localhost:4200, localhost:3000
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(
                        // Accessible public pages
                        "/api/v1/users/signup",
                        "/api/v1/users/signin",
                        "/api/v1/cars"
                ).permitAll()
                //Accessible to only ADMIN."api/v1/users/*", means all endpoints.
                .requestMatchers("/api/v1/users/*").hasRole("ADMIN")
                .requestMatchers("/api/v1/employees/*").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //.and()
                //.httpBasic(withDefaults()).formLogin()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        // Add JWT token filter
        return http.build();
    }

}
