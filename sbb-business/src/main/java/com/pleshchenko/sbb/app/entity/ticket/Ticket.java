package com.pleshchenko.sbb.app.entity.ticket;

import com.pleshchenko.sbb.app.entity.route.Schedule;

import javax.persistence.*;

/**
 * Created by РОМАН on 31.03.2017.
 */
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idPassenger")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
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