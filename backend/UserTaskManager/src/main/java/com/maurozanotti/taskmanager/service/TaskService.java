package com.maurozanotti.taskmanager.service;

import com.maurozanotti.taskmanager.models.Task;
import com.maurozanotti.taskmanager.models.TaskStatus;
import com.maurozanotti.taskmanager.models.User;
import com.maurozanotti.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskbyId(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getTasksByUser(User user) {
        return taskRepository.findByUser(user);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasksByStatus(User user, TaskStatus status) { return taskRepository.findByUserAndStatus(user, status); }
}
