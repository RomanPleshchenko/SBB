package com.pleshchenko.sbb.app.entity.segment;

import com.pleshchenko.sbb.app.entity.ticket.Ticket;
import com.pleshchenko.sbb.app.entity.ticket.Train;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "schedule")
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "segmentId")
    private Segment segment;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Ticket> tickets;

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

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
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

    public String  getDepartureTimeInFormat() {

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.GERMAN).withZone(ZoneOffset.UTC);
        String date = formatter.format(departureTime);
        return date;
    }

    public String  getDestinationTimeInFormat() {

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.GERMAN).withZone(ZoneOffset.UTC);
        String date = formatter.format(destinationTime);
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