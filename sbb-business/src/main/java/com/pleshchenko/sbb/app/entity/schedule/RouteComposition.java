package com.pleshchenko.sbb.app.entity.schedule;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Entity(name = "RouteComposition")
public class RouteComposition implements Comparable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "routeId")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "segmentId",nullable=false)
    private Segment segment;

    @Column(name = "departureTime")
    @NotNull
    private Integer departureTime;

    @Column(name = "destinationTime")
    @NotNull
    private Integer destinationTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public Integer getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Integer departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(Integer destinationTime) {
        this.destinationTime = destinationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteComposition that = (RouteComposition) o;

        return id.equals(that.id);
    }

    @Override
    public int compareTo(Object o) {
        return (getDepartureTime().compareTo(((RouteComposition)o).getDepartureTime()));
    }


}
