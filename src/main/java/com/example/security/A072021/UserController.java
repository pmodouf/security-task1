package com.example.security.A072021;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "register";  // return to the registration form
    }

    @PostMapping("/add")
    public String processRegistration(@Valid @ModelAttribute RegistrationForm registrationForm, BindingResult result) {


        if (result.hasErrors()) {
            return "register";  // return to the form if there are errors
        }

        BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
        UserModel newUser = new UserModel(registrationForm.getUsername(),encrypt.encode(registrationForm.getPassword()));


        userRepository.save(newUser);

        return "newUsers";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "showAllUsers";}
}