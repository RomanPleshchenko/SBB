package com.pleshchenko.sbb.model.model.entity.route;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by РОМАН on 31.03.2017.
 */
@Entity
public class Route {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "departureStationId")
    private int departureStationId;

    @Basic
    @Column(name = "destinationStationId")
    private int destinationStationId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartureStationId() {
        return departureStationId;
    }

    public void setDepartureStationId(int departureStationId) {
        this.departureStationId = departureStationId;
    }

    public int getDestinationStationId() {
        return destinationStationId;
    }

    public void setDestinationStationId(int destinationStationId) {
        this.destinationStationId = destinationStationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (id != route.id) return false;
        if (departureStationId != route.departureStationId) return false;
        if (destinationStationId != route.destinationStationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + departureStationId;
        result = 31 * result + destinationStationId;
        return result;
    }
}
