package com.fleetmanagementapp.controller;

import com.fleetmanagementapp.model.AuthRequest;
import com.fleetmanagementapp.model.User;
import com.fleetmanagementapp.repository.UserRepository;
import com.fleetmanagementapp.service.UserService;
import com.fleetmanagementapp.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;



    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }


    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        // Fetch the existing user, ensuring they exist
        User updatedUser = userService.updateUser(id, user);
        return updatedUser;
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    /***
     * SIGN UP ENDPOINT
     ************************************************/
    @PostMapping("/users/signup")
    public User signup(@RequestBody User user) {
        User existingUser = userRepository.findUserByEmail(user.getEmail());
        if (existingUser != null) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.USER);
        userRepository.save(user);
        return user;
    }

    /***
     * SIGN IN ENDPOINT
     ************************************************/
    @PostMapping("/users/signin")
    public Map<String, String> login(@RequestBody AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );

        User user = userRepository.findByUsername(authRequest.getUsername());
        if (user == null) {
            throw new IllegalArgumentException("Invalid username or password.");
        }

        Map<String, String> token = new HashMap<>();
        token.put("token", jwtUtils.generateToken(user));
        return token;
    }
}
