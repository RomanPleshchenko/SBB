package com.pleshchenko.sbb.app.entity.ticket;

import org.hibernate.validator.constraints.NotEmpty;

import javax.lang.model.element.Name;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Entity(name = "SitePrototype")
public class SitePrototype {

    @Id
    @Column(name = "id")
    private int id;

    @NotNull
    @NotEmpty
    @Column(name = "number")
    private String number;

    @NotNull
    @Column(name = "location")
    private String location;

    @NotNull
    @Column(name = "level")
    private String level;

    @ManyToOne
    @JoinColumn(name = "classId")
    private SiteCarClass siteCarClass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public SiteCarClass getSiteCarClass() {
        return siteCarClass;
    }

    public void setSiteCarClass(SiteCarClass siteCarClass) {
        this.siteCarClass = siteCarClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SitePrototype that = (SitePrototype) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "SitePrototype{" + "id=" + id + '}';
    }
}
