package com.example.TaskManagementApp.model;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String decscription;
    private String status; // Can be "Pending", "In Progress", or "Completed

@ManyToOne
@JoinColumn(name = "user_id")
private User user;
}