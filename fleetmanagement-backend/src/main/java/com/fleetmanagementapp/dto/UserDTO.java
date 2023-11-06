package com.fleetmanagementapp.dto;

import com.fleetmanagementapp.model.User;
import lombok.Data;

@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private User.Role role;
}
