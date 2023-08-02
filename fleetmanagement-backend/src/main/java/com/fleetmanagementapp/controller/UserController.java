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
    public UserController( UserService userService){
        this.userService = userService;
    }
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id){
        User user = userService.findUserById(id);
        return user;
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @PutMapping("users/{id}")
    public User updateUser(@PathVariable ("id") Long id, @RequestBody User user){
        userService.deleteUserById(id);
        user.setUserId(id);
        return userService.updateUser(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
    }


    /***
     * SIGN UP ENDPOINT
     ************************************************/
    @PostMapping("/users/signup")
    public User signup(@RequestBody User user) {
        User existingUser = userRepository.findUserByEmail(user.getEmail());
        if (existingUser != null) {
            return null;
        }
        user.setUsername(user.getUsername());
        user.setFirstName(user.getFirstName());
        user.setSurname(user.getSurname());
        user.setPhone(user.getPhone());
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.Role.USER);
       // user.setRole(User.Role.ADMIN);
        userRepository.save(user);
        return user;
    }

    /***
     * SIGN IN ENDPOINT
     ************************************************/
    @PostMapping("/users/signin")
    public Map<String, String> login(@RequestBody AuthRequest authRequest) {
        Map<String, String> token = new HashMap<>();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        User user = userRepository.findByUsername(authRequest.getUsername());
        token.put("token", jwtUtils.generateToken(user));
        return token;
    }

}
