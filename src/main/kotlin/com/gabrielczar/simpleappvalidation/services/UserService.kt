package com.gabrielczar.simpleappvalidation.services

import com.gabrielczar.simpleappvalidation.domain.User
import com.gabrielczar.simpleappvalidation.repositories.UserRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
@Transactional
class UserService(private val repository: UserRepository) : IGenericService<User> {

    override fun create(entity: User): User {
        val createEntity = entity.copy(
                createdAt = LocalDateTime.now(),
                updateAt = LocalDateTime.now()
        )
        return repository.save(createEntity)
    }

    override fun update(entity: User): User {
        val updateEntity = entity.copy(
                createdAt = entity.id?.let { repository.getOne(it).createdAt },
                updateAt = LocalDateTime.now()
        )
        return repository.save(updateEntity)
    }

    override fun delete(id: Long) = repository.deleteById(id)

    override fun get(id: Long): User = repository.getOne(id)

    override fun list(): List<User> = repository.findAll()

    override fun exists(id: Long): Boolean = repository.existsById(id)
}