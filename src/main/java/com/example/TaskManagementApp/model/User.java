package com.example.TaskManagementApp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role; // Can be "User" or "Admin"
    @OneToMany(mappedBy = "user")
    private List<Task> task;
}
