package com.pleshchenko.sbb.app.entity.ticket;

import com.pleshchenko.sbb.app.entity.schedule.Schedule;

import javax.persistence.*;

/**
 * Created by РОМАН on 30.04.2017.
 */
@Entity
@Table(name = "TripsSite")
public class TripsSite {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "sitePrototypeId")
    private SitePrototype sitePrototypeId;

    @Column(name = "sold")
    private boolean sold;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public SitePrototype getSitePrototypeId() {
        return sitePrototypeId;
    }

    public void setSitePrototypeId(SitePrototype sitePrototypeId) {
        this.sitePrototypeId = sitePrototypeId;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripsSite tripsSite = (TripsSite) o;

        return id.equals(tripsSite.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
