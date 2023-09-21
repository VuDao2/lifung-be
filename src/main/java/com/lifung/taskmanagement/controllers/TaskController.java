package com.lifung.taskmanagement.controllers;

import com.lifung.taskmanagement.TaskDTO;
import com.lifung.taskmanagement.entites.Task;
import com.lifung.taskmanagement.services.CreatingTaskDTO;
import com.lifung.taskmanagement.services.TaskService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@OpenAPIDefinition(info = @Info(title = "To do list management API", version = "v1"))
@SecurityRequirement(name = "basicAuth")
@RequestMapping(value = "tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskDTO> getTasksOfCurrentLoggedInUser(@AuthenticationPrincipal UserDetails userDetails) {
        return taskService.getAllTaskOfUser(userDetails.getUsername());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public TaskDTO createTask(@RequestBody CreatingTaskDTO task, @AuthenticationPrincipal UserDetails userDetails) {
        return taskService.createTaskForUser(userDetails.getUsername(), task);
    }

}
