package com.gabrielczar.simpleappvalidation.validations

import com.gabrielczar.simpleappvalidation.domain.User
import com.gabrielczar.simpleappvalidation.exceptions.ApplicationException
import com.gabrielczar.simpleappvalidation.exceptions.ValidationException
import org.springframework.stereotype.Component
import org.springframework.validation.Errors

@Component
class UserValidator : IGenericValidator<User> {

    override fun validate(target: User, errors: Errors) {
        if (errors.hasErrors()) {
            throw ValidationException(errors = ApplicationException.getErrors(errors))
        }
    }

}
