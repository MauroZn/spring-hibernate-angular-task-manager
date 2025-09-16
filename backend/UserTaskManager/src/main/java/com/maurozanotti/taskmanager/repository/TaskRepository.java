package com.maurozanotti.taskmanager.repository;

import com.maurozanotti.taskmanager.models.Task;
import com.maurozanotti.taskmanager.models.TaskStatus;
import com.maurozanotti.taskmanager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);
    List<Task> findByUser(User user);
    List<Task> findByUserAndStatus(User user, TaskStatus status);
}
