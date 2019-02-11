package com.documents.hw_6.validation;

import com.documents.hw_6.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {
   @Autowired
   UserService userService;
   public void initialize(UniqueLogin constraint) {
   }

   public boolean isValid(String login, ConstraintValidatorContext context) {
      return login != null && userService.getByLogin(login) == null;
   }
}
