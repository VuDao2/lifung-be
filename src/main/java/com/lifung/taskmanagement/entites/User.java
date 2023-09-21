package com.lifung.taskmanagement.entites;


import javax.persistence.*;
import java.util.List;

@Entity(name = "lifung_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;

    @OneToMany(mappedBy = "user")
    List<Task> taskList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
