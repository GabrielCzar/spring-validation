package com.gabrielczar.simpleappvalidation.domain

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
data class User (@GeneratedValue(strategy = IDENTITY)
                 @Id val id: Long?,
                 @field:NotNull var name: String?,
                 @field:Email var email: String?,
                 @field:Size(min = 5) var username: String?,
                 var createdAt : LocalDateTime?,
                 var updateAt  : LocalDateTime?
)