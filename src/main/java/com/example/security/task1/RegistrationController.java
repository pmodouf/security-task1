package com.example.security.task1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegistrationController {


/*
    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "register";  // return to the registration form
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute RegistrationForm registrationForm, BindingResult result) {
        if (result.hasErrors()) {
            return "register";  // return to the form if there are errors
        }

        UserModel newUser = new UserModel(registrationForm.getUsername(), registrationForm.getPassword());
        userRepository.save(newUser);

        return "newUsers";
    }

*/
}


