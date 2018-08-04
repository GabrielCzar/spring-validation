package com.gabrielczar.simpleappvalidation.controllers

import com.gabrielczar.simpleappvalidation.exceptions.ValidationException
import com.gabrielczar.simpleappvalidation.wrappers.ErrorWrapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class UserControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException::class)
    fun validateErrorException(req : HttpServletRequest, e : ValidationException) = ErrorWrapper(message = e.message, fieldErrors = e.errors, path = req.requestURI)

}