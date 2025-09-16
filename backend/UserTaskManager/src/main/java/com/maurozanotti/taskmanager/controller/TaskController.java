package com.maurozanotti.taskmanager.controller;

import com.maurozanotti.taskmanager.models.Task;
import com.maurozanotti.taskmanager.models.TaskStatus;
import com.maurozanotti.taskmanager.models.User;
import com.maurozanotti.taskmanager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task create(Authentication authentication, @RequestBody Task task) {
        User user = (User) authentication.getPrincipal();
        task.setUser(user);
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getTasksByUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return taskService.getTasksByUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(Authentication authentication, @PathVariable Long id, @RequestBody Task taskDetails) {
        Task existingTask = taskService.getTaskbyId(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        User user = (User) authentication.getPrincipal();

        if (!existingTask.getUser().getId().equals(user.getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        existingTask.setTitle(taskDetails.getTitle());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setStatus(taskDetails.getStatus());

        Task updatedTask = taskService.updateTask(existingTask);

        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(Authentication authentication, @PathVariable Long id) {

        Task existingTask = taskService.getTaskbyId(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        User user = (User) authentication.getPrincipal();

        if (!existingTask.getUser().getId().equals(user.getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        taskService.deleteTask(id);
        return null;
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(Authentication authentication, @PathVariable TaskStatus status) {
        User user = (User) authentication.getPrincipal();
        return taskService.getTasksByStatus(user, status);
    }
}

