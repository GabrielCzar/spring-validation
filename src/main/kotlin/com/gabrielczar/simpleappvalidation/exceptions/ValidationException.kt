package com.gabrielczar.simpleappvalidation.exceptions

import com.gabrielczar.simpleappvalidation.dto.ErrorDTO

class ValidationException(val errors : List<ErrorDTO>) : ApplicationException("Validation.Exception")