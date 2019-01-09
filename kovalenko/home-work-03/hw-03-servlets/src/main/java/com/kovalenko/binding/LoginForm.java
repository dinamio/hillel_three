package com.kovalenko.binding;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class LoginForm {

    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
