package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepo {
    private Map<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong();

        @PostConstruct
    public void init(){
        save(new User(null, "Bob", "Wilson", "a@gmail.com"));
        save(new User(null, "John", "Smith", "a@gmail.com"));
        save(new User(null, "Jane", "Doe", "a@gmail.com"));
        save(new User(null, "Jack", "Smith", "a@gmail.com"));
    }

    public List<User> findAll(){
        return new ArrayList<>(users.values());
    }

    public User getById(long id){
        return users.get(id);
    }

    public User save(User user){
        if (user.getId() == null) {
            user.setId(counter.incrementAndGet());
        }

        users.put(user.getId(), user);
        return user;
    }

    public boolean deleteById(long id){
        return users.remove(id) != null;
    }
}