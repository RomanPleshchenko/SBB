package com.pleshchenko.sbb.model.entity.route;

import com.pleshchenko.sbb.model.entity.Ticket;
import com.pleshchenko.sbb.model.entity.Train;
import com.pleshchenko.sbb.model.converter.InstantAttributeConverter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "departureTime")
    private Timestamp departureTime;

    @Column(name = "destinationTime")
    private Timestamp destinationTime;

//    @Column(name = "departureTime")
////    @Convert(converter = InstantAttributeConverter.class)
//    private Instant departureTime;
//
//    @Column(name = "destinationTime")
////    @Convert(converter = InstantAttributeConverter.class)
//    private Instant destinationTime;

    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;

    @ManyToOne
    @JoinColumn(name = "routeId")
    private Route route;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Ticket> tickets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getShowing(){
        return getTrain().getNumber() + "(" + id + ")" + " [" + departureTime + " - " + getDestinationTime() + "]";
    }

//    public List<Ticket> getTickets() {
//        return tickets;
//    }
//
//    public void setTickets(List<Ticket> tickets) {
//        this.tickets = tickets;
//    }

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