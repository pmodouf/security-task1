package com.example.security.A072021;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    @GetMapping()
    public String getSessions() {
        return "Doing admin tasks";
    }

}
