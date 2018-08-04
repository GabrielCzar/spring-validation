package com.gabrielczar.simpleappvalidation.controllers

import com.gabrielczar.simpleappvalidation.domain.User
import com.gabrielczar.simpleappvalidation.services.UserService
import com.gabrielczar.simpleappvalidation.validations.UserValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController @Autowired
constructor(service: UserService, validator: UserValidator)
    : GenericController<User> (service, validator)