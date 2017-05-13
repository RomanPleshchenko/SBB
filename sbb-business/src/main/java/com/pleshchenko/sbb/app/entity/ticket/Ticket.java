package com.pleshchenko.sbb.app.entity.ticket;

import com.pleshchenko.sbb.app.entity.authorization.User;
import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.entity.schedule.Station;
import com.sun.istack.internal.Nullable;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by РОМАН on 31.03.2017.
 */
@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "departureStationId")
    private Station departureStation;

    @ManyToOne
    @JoinColumn(name = "destinationStationId")
    private Station destinationStation;

    @Column(name = "departureTime")
//    @NotNull
    private Instant departureTime;

    @Column(name = "destinationTime")
//    @NotNull
    private Instant destinationTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ticketComposition",
            joinColumns = { @JoinColumn(name = "ticketId",nullable=false)},
            inverseJoinColumns = { @JoinColumn(name = "tripsSiteId")})
    private Set<TripsSite> tripsSites = new HashSet<TripsSite>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Set<TripsSite> getTripsSites() {
        return tripsSites;
    }

    public void setTripsSites(Set<TripsSite> tripsSites) {
        this.tripsSites = tripsSites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        return result;
    }
}