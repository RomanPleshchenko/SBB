package com.pleshchenko.sbb.model.entity;

import com.pleshchenko.sbb.model.entity.authorization.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by РОМАН on 31.03.2017.
 */
@Entity
public class Passenger {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "surname")
    private String surname;

    @Basic
    @Column(name = "birthDate")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    @OneToMany(mappedBy = "passanger", cascade = {CascadeType.ALL})
//    private List<Ticket> tickets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (id != passenger.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;

        return result;
    }
}