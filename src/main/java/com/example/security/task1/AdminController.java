package com.example.security.task1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {
    private UserRepository userRepository;
    @GetMapping()
    public String getSessions() {
        return "Doing admin tasks\n";
    }

}
