package com.example.TaskManagementApp.controller;

import com.example.TaskManagementApp.model.User;
import com.example.TaskManagementApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }
}
