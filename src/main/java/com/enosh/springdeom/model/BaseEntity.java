package com.enosh.springdeom.model;


import javax.persistence.*;


@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    protected Long id;

}

