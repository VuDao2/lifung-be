package com.lifung.taskmanagement.entites;

import com.lifung.taskmanagement.enums.TaskStatus;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private TaskStatus taskStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
