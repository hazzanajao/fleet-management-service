package com.fleetmanagementapp.service;

import com.fleetmanagementapp.model.User;
import com.fleetmanagementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    /**
     * Injecting UserRepository for autowiring
     ******************************************/
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    /**
     * CRUD : Create, Read, Update and Delete
     **********************************************/

    public User createUser(User user){
        return userRepository.save(user);
    }
    // Can read all Users
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    // Can read one User by id
    public User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    // Can update User
    public User updateUser(User user){
        return userRepository.save(user);
    }
    // Can delete User by id
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
