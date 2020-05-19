package com.enosh.springdeom.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@MappedSuperclass
public class UserEntity extends BaseEntity {

    @NotEmpty
    @Length(min = 5, max = 50)
    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @NotEmpty
    @Length(min = 5)
    @Column(name = "password", nullable = false)
    protected String password;
}
