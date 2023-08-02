package com.fleetmanagementapp.controller;

import com.fleetmanagementapp.model.User;
import com.fleetmanagementapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

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
}
