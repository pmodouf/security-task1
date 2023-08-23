package com.example.security.A072021;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class RegistrationForm {

    @NotBlank(message = "Användarnamn får inte vara tomt")
    private String username;

    @NotBlank(message = "Lösenord får inte vara tomt")
    @Size(min = 4, max = 4, message = "Lösenord måste vara exakt 4 siffror")
    @Pattern(regexp = "^[0-9]{4}$", message = "Lösenord måste bestå av endast 4 siffror")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //nytt krav på lösenord
    /*
    @NotBlank(message = "Lösenord får inte vara tomt")
    @Size(min = 8, message = "Lösenord måste vara minst 8 tecken långt")
    @Pattern.List({
            @Pattern(regexp = ".*[a-z].*", message = "Lösenord måste innehålla minst en liten bokstav"),
            @Pattern(regexp = ".*[A-Z].*", message = "Lösenord måste innehålla minst en stor bokstav"),
            @Pattern(regexp = ".*\\d.*", message = "Lösenord måste innehålla minst en siffra"),
            @Pattern(regexp = ".*[!@#$%^&*+=?-].*", message = "Lösenord måste innehålla minst ett specialtecken")

     */


}
