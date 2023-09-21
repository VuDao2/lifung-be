package com.lifung.taskmanagement.services;

import com.lifung.taskmanagement.entites.User;
import com.lifung.taskmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserByName(String userName) {
        Optional<User> optUser = userRepository.findByUserName(userName);
        if (!optUser.isPresent()) {
            throw new EntityNotFoundException("Not found user with given userName: " + userName);
        }

        return optUser.get();
    }
}
