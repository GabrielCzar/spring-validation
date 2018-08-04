package com.gabrielczar.simpleappvalidation.validations

import org.springframework.validation.Errors

interface IGenericValidator<T> {
    fun validate(target: T, errors: Errors)
}
