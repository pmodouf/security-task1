package com.example.security;


import com.example.security.task1.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        UserRepository userRepository;
        SpringApplication.run(Main.class, args);
    }

}
