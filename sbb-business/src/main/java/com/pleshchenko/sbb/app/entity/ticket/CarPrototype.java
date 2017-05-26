package com.pleshchenko.sbb.app.entity.ticket;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Entity
@Table(name = "CarPrototype")
public class CarPrototype {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "classId")
    private SiteCarClass siteCarClass;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "carPrototypeComposition",
            joinColumns = { @JoinColumn(name = "carPrototypeId") },
            inverseJoinColumns = { @JoinColumn(name = "sitePrototypeId")})
    private Set<SitePrototype> sitePrototypes = new HashSet<SitePrototype>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SiteCarClass getSiteCarClass() {
        return siteCarClass;
    }

    public void setSiteCarClass(SiteCarClass siteCarClass) {
        this.siteCarClass = siteCarClass;
    }

    public Set<SitePrototype> getSitePrototypes() {
        return sitePrototypes;
    }

    public void setSitePrototypes(Set<SitePrototype> sitePrototypes) {
        this.sitePrototypes = sitePrototypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarPrototype that = (CarPrototype) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "CarPrototype{" + "id=" + id + '}';
    }
}
