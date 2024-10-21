package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    private User user;



    public List<User> findAll() {

        return userRepo.findAll();
    }

    public User getById(Long id) {
        return userRepo.getById(id);
    }
    public boolean deleteById(Long id) {
        return userRepo.deleteById(id);
    }
}
