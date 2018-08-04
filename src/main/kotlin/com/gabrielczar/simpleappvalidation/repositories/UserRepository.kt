package com.gabrielczar.simpleappvalidation.repositories

import com.gabrielczar.simpleappvalidation.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional
interface UserRepository : JpaRepository<User, Long>
