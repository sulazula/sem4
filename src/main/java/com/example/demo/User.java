package com.example.demo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {

    private Long id;
    private String fName;
    private String lName;
    private String email;

    public User() {
    }

    public User(Long id, String fName, String lName, String email) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }
}
