package com.fleetmanagementapp.service;

import com.fleetmanagementapp.model.User;
import com.fleetmanagementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * Injecting UserRepository for autowiring
     ******************************************/
    @Autowired
    private UserRepository userRepository;

    // Constructor-based dependency injection for better testability
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * CRUD: Create, Read, Update and Delete
     **********************************************/

    // Create a new user
    public User createUser(User user) {
        // Check if a user with the given email already exists
        if (userRepository.findUserByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists.");
        }
        user.setPassword(user.getPassword()); // Ensure password encoding happens elsewhere
        return userRepository.save(user);
    }

    // Retrieve all users
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a user by ID
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User with ID " + id + " not found.")
        );
    }

    // Update an existing user
    public User updateUser(Long id, User user) {
        // Fetch the existing user to ensure they exist
        User existingUser = findUserById(id);

        // Update only allowed fields
        existingUser.setFirstName(user.getFirstName());
        existingUser.setSurname(user.getSurname());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());

        // Check if a new password is provided, and encode it
        if (user.getPassword() != null && !user.getPassword().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        // Save and return the updated user
        return userRepository.save(existingUser);
    }


    // Delete a user by ID
    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User with ID " + id + " does not exist.");
        }
        userRepository.deleteById(id);
    }


}
