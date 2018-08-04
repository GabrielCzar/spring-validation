package com.gabrielczar.simpleappvalidation.exceptions

import com.gabrielczar.simpleappvalidation.dto.ErrorDTO
import org.springframework.http.HttpStatus
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
open class ApplicationException(message : String? = null) : Exception(message) {
    companion object {
        fun getErrors(errors: Errors) : List<ErrorDTO> {
            return errors.fieldErrors.map { e -> ErrorDTO(e.field, e.defaultMessage) }
        }
    }
}