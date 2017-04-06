package com.pleshchenko.sbb.model.model.entity.route;

import com.pleshchenko.sbb.model.model.entity.Train;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Schedule {
    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "trainId")
    private int trainId;

    @Basic
    @Column(name = "departureTime")
    private Timestamp departureTime;

    @Basic
    @Column(name = "destinationTime")
    private Timestamp destinationTime;

    @Basic
    @Column(name = "routeId")
    private int routeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(Timestamp destinationTime) {
        this.destinationTime = destinationTime;
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

        Schedule schedule = (Schedule) o;

        if (id != schedule.id) return false;
        if (trainId != schedule.trainId) return false;
        if (routeId != schedule.routeId) return false;
        if (departureTime != null ? !departureTime.equals(schedule.departureTime) : schedule.departureTime != null)
            return false;
        if (destinationTime != null ? !destinationTime.equals(schedule.destinationTime) : schedule.destinationTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + trainId;
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (destinationTime != null ? destinationTime.hashCode() : 0);
        result = 31 * result + routeId;
        return result;
    }
}
