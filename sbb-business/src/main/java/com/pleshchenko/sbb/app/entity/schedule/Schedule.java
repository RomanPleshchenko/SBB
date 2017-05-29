package com.pleshchenko.sbb.app.entity.schedule;

import com.pleshchenko.sbb.app.entity.ticket.Train;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "departureTime")
    @NotNull
    private Instant departureTime;

    @Column(name = "destinationTime")
    @NotNull
    private Instant destinationTime;

    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "routeId")
    private Route route;

    @Column(name = "active")
    boolean active;

    @Column(name = "composed")
    boolean composed;

    public Schedule() {
    }

    public Schedule(Route route, Train train, Instant departureTime) {
        this.route = route;
        this.train = train;
        this.departureTime = departureTime;

        int maxValue = 0;
        for (RouteComposition routeComposition:route.getRouteCompositions()){
            maxValue = Integer.max(routeComposition.getDestinationTime(),maxValue);
        }

        this.destinationTime = departureTime.plusSeconds(maxValue*60);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instant getDepartureTime() {

        return departureTime;
    }

    public void setDepartureTime(Instant departureTime) {
        this.departureTime = departureTime;
    }

    public Instant getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(Instant destinationTime) {
        this.destinationTime = destinationTime;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isComposed() {
        return composed;
    }

    public void setComposed(boolean composed) {
        this.composed = composed;
    }


    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", departureTime=" + departureTime +
                ", destinationTime=" + destinationTime +
                ", train=" + train +
                ", route=" + route +
                ", active=" + active +
                ", composed=" + composed +
                '}';
    }

    public String  getDepartureTimeInFormat() {

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.GERMAN).withZone(ZoneOffset.UTC);
        String date = formatter.format(departureTime.plusSeconds(3*3600));
        return date;
    }

    public String  getDestinationTimeInFormat() {

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.GERMAN).withZone(ZoneOffset.UTC);
        String date = formatter.format(destinationTime.plusSeconds(3*3600));
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule = (Schedule) o;

        if (id != schedule.id) return false;
        if (departureTime != null ? !departureTime.equals(schedule.departureTime) : schedule.departureTime != null)
            return false;
        if (destinationTime != null ? !destinationTime.equals(schedule.destinationTime) : schedule.destinationTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        return result;
    }
}