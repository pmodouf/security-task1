package com.example.security.A072021;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
                        .requestMatchers("/", "/public", "/register", "/user/**").permitAll()
                        .requestMatchers("/api/**").hasRole("USER")
                        .requestMatchers("/admin").hasRole("ADMIN"))
                .formLogin(Customizer.withDefaults())
        ;
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService2() {
        UserDetails user = User.withUsername("user")
                .password("{bcrypt}$2a$12$ZwMay4o1NfLYQmzV51/bwuXYxHsd5pXbzl0YTzQDl4waaEcZVQzeu")
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("{bcrypt}$2a$12$ZPYrl0QvByrSOLmcoYLIyeV8OSw3hBB2BuerBziDwj.U/8KBFXAaC").roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }


    //.password("{bcrypt}$2a$10$CmynNnwTzLU4QQ8XslbY8O0TlT8nIrrss3yGR0JUeTPXC7UPLNXZe")

    //.password("{bcrypt}$2a$10$CmynNnwTzLU4QQ8XslbY8O0TlT8nIrrss3yGR0JUeTPXC7UPLNXZe").roles("USER", "ADMIN")



    }










