package com.pleshchenko.sbb.app.entity.ticket;

import com.pleshchenko.sbb.app.entity.authorization.User;
import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.sun.istack.internal.Nullable;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by РОМАН on 31.03.2017.
 */
@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ticketComposition",
            joinColumns = { @JoinColumn(name = "ticketId")},
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