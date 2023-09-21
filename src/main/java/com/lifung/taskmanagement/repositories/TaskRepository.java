package com.lifung.taskmanagement.repositories;

import com.lifung.taskmanagement.entites.Task;
import com.lifung.taskmanagement.entites.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByUser(User user);
}
