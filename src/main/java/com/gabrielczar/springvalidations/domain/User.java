package com.gabrielczar.springvalidations.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

}
