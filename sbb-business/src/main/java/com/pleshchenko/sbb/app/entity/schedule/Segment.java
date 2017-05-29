package com.pleshchenko.sbb.app.entity.schedule;

import javax.persistence.*;
import java.util.List;

/**
 * Created by РОМАН on 31.03.2017.
 */
@Entity
@Table(name = "Segment")
public class Segment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public Segment() {
    }

    public Segment(Station departureStation, Station destinationStation) {
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "departureStationId")
    private Station departureStation;

    @ManyToOne
    @JoinColumn(name = "destinationStationId")
    private Station destinationStation;

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public Station getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(Station destinationStation) {
        this.destinationStation = destinationStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Segment segment = (Segment) o;

        return id == segment.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return departureStation.getName() + " - " + destinationStation.getName();
    }
}