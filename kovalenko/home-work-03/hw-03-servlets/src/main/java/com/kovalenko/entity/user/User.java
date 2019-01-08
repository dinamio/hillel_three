package com.kovalenko.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private long id;

    @NotBlank
    private String name;
    @NotBlank
    private String login;
    @NotBlank
    private String password;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
