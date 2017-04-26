package com.pleshchenko.sbb.app.entity.ticket;

import javax.persistence.*;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Entity
@Table(name = "CarPrototypeComposition")
public class CarPrototypeComposition {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "carPrototypeId")
    private CarPrototype carPrototype;

    @ManyToOne
    @JoinColumn(name = "sitePrototypeId")
    private SitePrototype sitePrototype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarPrototype getCarPrototype() {
        return carPrototype;
    }

    public void setCarPrototype(CarPrototype carPrototype) {
        this.carPrototype = carPrototype;
    }

    public SitePrototype getSitePrototype() {
        return sitePrototype;
    }

    public void setSitePrototype(SitePrototype sitePrototype) {
        this.sitePrototype = sitePrototype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarPrototypeComposition that = (CarPrototypeComposition) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
