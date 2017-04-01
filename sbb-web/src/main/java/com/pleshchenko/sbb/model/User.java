package com.pleshchenko.sbb.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name="password", nullable=false)
    private String password;

    @NotEmpty
    @Column(name="name", nullable=false)
    private String name;

}
