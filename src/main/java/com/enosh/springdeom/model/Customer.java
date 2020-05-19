package com.enosh.springdeom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer extends UserEntity {

    @NotEmpty
    @Length(min = 2, max = 30)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty
    @Length(min = 2, max = 30)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    public Customer(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
