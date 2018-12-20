package com.kovalenko.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private long id;

    @NotNull
    @NotEmpty
    private String name;
    private String login;
    private String password;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
