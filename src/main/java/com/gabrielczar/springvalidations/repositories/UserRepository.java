package com.gabrielczar.springvalidations.repositories;

import com.gabrielczar.springvalidations.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(@Param("name") String name);
}
