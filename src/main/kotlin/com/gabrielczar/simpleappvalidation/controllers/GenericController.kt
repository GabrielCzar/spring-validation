package com.gabrielczar.simpleappvalidation.controllers

import com.gabrielczar.simpleappvalidation.exceptions.ValidationException
import com.gabrielczar.simpleappvalidation.services.IGenericService
import com.gabrielczar.simpleappvalidation.validations.IGenericValidator
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

abstract class GenericController<T> (
        private val service: IGenericService<T>,
        private val validator: IGenericValidator<T>
) {

    @Throws(ValidationException::class)
    @PostMapping(consumes = [APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE], produces = [APPLICATION_JSON_UTF8_VALUE])
    fun create(@RequestBody @Valid entity : T, errors : Errors) : ResponseEntity<T> {
        validator.validate(entity, errors)
        return ResponseEntity
                .ok(service.create(entity))
    }

    @PutMapping(consumes = [APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE], produces = [APPLICATION_JSON_UTF8_VALUE])
    fun update(@RequestBody entity: T, errors : Errors): ResponseEntity<T> {
        validator.validate(entity, errors)
        return ResponseEntity
                .ok(service.create(entity))
    }

    @GetMapping(value = ["/{id}/exists"])
    fun exists(@PathVariable("id") id: Long): ResponseEntity<Boolean> = ResponseEntity.ok(service.exists(id))

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable("id") id: Long): ResponseEntity<T> = ResponseEntity.ok(service.get(id))

    @GetMapping
    fun findAll(): ResponseEntity<List<T>> = ResponseEntity.ok(service.list())

}