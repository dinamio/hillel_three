package com.kovalenko.binding;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginForm {

    @NotNull
    @NotEmpty
    private String login;
    @NotNull
    @NotEmpty
    private String password;
}
