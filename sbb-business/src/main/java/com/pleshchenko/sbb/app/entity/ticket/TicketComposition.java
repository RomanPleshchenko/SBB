package com.pleshchenko.sbb.app.entity.ticket;

import javax.persistence.*;

/**
 * Created by РОМАН on 13.05.2017.
 */
@Entity
@Table(name = "TicketComposition")
public class TicketComposition {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ticketId")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "tripsSiteId")
    private TripsSite tripsSite;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public TripsSite getTripsSite() {
        return tripsSite;
    }

    public void setTripsSite(TripsSite tripsSite) {
        this.tripsSite = tripsSite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketComposition that = (TicketComposition) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
