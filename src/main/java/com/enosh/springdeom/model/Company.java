package com.enosh.springdeom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(
        cascade = CascadeType.ALL,
        mappedBy = "company",
        orphanRemoval = true,
        fetch = FetchType.EAGER
    )
    private List<Coupon> coupons = new ArrayList<>();

    public Company(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
