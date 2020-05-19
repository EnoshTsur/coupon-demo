package com.enosh.springdeom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "company")
public class Company extends UserEntity {

    @NotEmpty
    @Length(min = 2, max = 30)
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public Company(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
