package com.example.TaskManagementApp.repository;

import com.example.TaskManagementApp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
