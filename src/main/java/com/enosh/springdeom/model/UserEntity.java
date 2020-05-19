package com.enosh.springdeom.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public class UserEntity extends BaseEntity {

    @NotEmpty
    @Length(min = 5, max = 50)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotEmpty
    @Length(min = 5)
    @Column(name = "password", nullable = false)
    private String password;
}
