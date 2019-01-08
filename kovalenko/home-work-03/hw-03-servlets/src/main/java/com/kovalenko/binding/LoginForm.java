package com.kovalenko.binding;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginForm {

    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
