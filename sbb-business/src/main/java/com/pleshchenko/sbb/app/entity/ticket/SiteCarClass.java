package com.pleshchenko.sbb.app.entity.ticket;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Entity(name = "SiteCarClass")
public class SiteCarClass {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    @NotEmpty
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteCarClass that = (SiteCarClass) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
