package com.pleshchenko.sbb.app.entity.ticket;

import javax.persistence.*;

/**
 * Created by РОМАН on 30.04.2017.
 */
@Entity
@Table(name = "TrainComposition")
public class TrainComposition {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "departureStationId")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainComposition that = (TrainComposition) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}


