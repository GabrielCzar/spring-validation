package com.gabrielczar.simpleappvalidation.wrappers

import com.fasterxml.jackson.annotation.JsonInclude
import com.gabrielczar.simpleappvalidation.dto.ErrorDTO
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorWrapper(
        val timestamp: LocalDateTime = LocalDateTime.now(),
        val status: Int = 400,
        val error: String = "Bad Request",
        val message: String?,
        val path : String?,
        val fieldErrors: List<ErrorDTO>
)