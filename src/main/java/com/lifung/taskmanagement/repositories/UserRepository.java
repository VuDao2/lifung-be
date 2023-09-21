package com.lifung.taskmanagement.repositories;

import com.lifung.taskmanagement.entites.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
