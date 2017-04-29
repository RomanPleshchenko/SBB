package com.pleshchenko.sbb.app.entity.ticket;

import javax.persistence.*;

/**
 * Created by РОМАН on 30.04.2017.
 */
@Entity
@Table(name = "Car")
public class Car {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "carPrototypeId")
    private CarPrototype carPrototype;

    @Column(name = "number")
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarPrototype getCarPrototype() {
        return carPrototype;
    }

    public void setCarPrototype(CarPrototype carPrototype) {
        this.carPrototype = carPrototype;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id == car.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
