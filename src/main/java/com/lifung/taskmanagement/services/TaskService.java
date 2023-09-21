package com.lifung.taskmanagement.services;

import com.lifung.taskmanagement.TaskDTO;
import com.lifung.taskmanagement.entites.Task;
import com.lifung.taskmanagement.entites.User;
import com.lifung.taskmanagement.enums.TaskStatus;
import com.lifung.taskmanagement.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public List<TaskDTO> getAllTaskOfUser(String userName) {
        User user = userService.findUserByName(userName);

        return taskRepository.findByUser(user)
                .stream()
                .map(TaskService::toTaskDTO)
                .collect(Collectors.toList());
    }


    public TaskDTO createTaskForUser(String userName, CreatingTaskDTO dto) {
        User user = userService.findUserByName(userName);

        Task task = new Task();

        task.setTaskStatus(TaskStatus.IN_PROGRESS);
        task.setUser(user);
        task.setDescription(dto.getDescription());

        task = taskRepository.save(task);
        return toTaskDTO(task);
    }

    private static TaskDTO toTaskDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setDescription(task.getDescription());
        dto.setTaskStatus(task.getTaskStatus());
        dto.setId(task.getId());
        return dto;
    }

}
