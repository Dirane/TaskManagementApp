package com.example.TaskManagementApp.controller;

import com.example.TaskManagementApp.model.Task;
import com.example.TaskManagementApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public String getAllTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("task", tasks);
        return tasks.toString();
//        return taskService.getAllTasks();
    }
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @GetMapping("/new")
    public String showNewTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "new-task";
    }

    @PostMapping
    public String createTask(@ModelAttribute("task") Task task) {
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task Id:" + id));
        model.addAttribute("task", task);
        return "edit-task";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute("task") Task task) {
        task.setId(id);
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
