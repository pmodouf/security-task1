package com.example.security.task1;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class UserModel {

    @Id
    @GeneratedValue
    protected Long id;

    String name;

    String password;

    public UserModel(String name, String password){
        this.name = name;
        this.password = password;
    }
}
