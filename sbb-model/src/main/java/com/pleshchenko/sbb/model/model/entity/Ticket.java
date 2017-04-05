package com.pleshchenko.sbb.model.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by РОМАН on 31.03.2017.
 */
@Entity
public class Ticket {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "idPassenger")
    private int idPassenger;

    @Basic
    @Column(name = "routeId")
    private int routeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (idPassenger != ticket.idPassenger) return false;
        if (routeId != ticket.routeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idPassenger;
        result = 31 * result + routeId;
        return result;
    }
}
