package com.fleetmanagementapp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="User_ID")
    private long userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(name = "First_Name",length=20)
    private String firstName;

    @Column(name = "Sur_Name", length=20)
    private String surname;

    @Column(name = "Phone",length=20)
    private String phone;

    @Column(name = "Address",length=200)
    private String address;

    @Column(name = "Email", unique = true,length=100)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String username, String password, Role role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public enum Role {

        USER ( "Customer"),
        ADMIN ("Manager");
        public String description;

        Role(String description) {
            this.description = description;
        }
        @JsonCreator
        public static Role fromNode(JsonNode node) {
            if (!node.has("name"))
                return null;

            String name = node.get("name").asText();

            return Role.valueOf(name);
        }
        @JsonProperty
        public String getName() {
            return name();
        }
    }


}
