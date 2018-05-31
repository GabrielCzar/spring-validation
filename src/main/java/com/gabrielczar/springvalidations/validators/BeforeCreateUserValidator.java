package com.gabrielczar.springvalidations.validators;

import com.gabrielczar.springvalidations.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateUserValidator")
public class BeforeCreateUserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final User user = (User) target;
        if (checkInputString(user.getName())) {
            errors.rejectValue("name", "name.empty");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
