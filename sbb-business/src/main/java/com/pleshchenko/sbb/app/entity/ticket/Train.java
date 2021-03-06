package com.pleshchenko.sbb.app.entity.ticket;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by РОМАН on 31.03.2017.
 */
@Entity
@Table(name = "Train")
public class Train {

    @Id
    @Column(name = "id")
    private int id;

    @NotNull
    @NotEmpty
    @Column(name = "number")
    private String number;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "trainComposition",
            joinColumns = { @JoinColumn(name = "trainId") },
            inverseJoinColumns = { @JoinColumn(name = "carId")})
    private Set<Car> cars = new HashSet<Car>();

    @OneToMany(mappedBy = "train",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<TrainComposition> trainCompositions;

    public Train() {
    }

    public Train(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {

        int capacity = 0;

        for (Car car:cars){
            capacity += car.getCarPrototype().getSitePrototypes().size();
        }

        return capacity;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<TrainComposition> getTrainCompositions() {
        return trainCompositions;
    }

    public void setTrainCompositions(Set<TrainComposition> trainCompositions) {
        this.trainCompositions = trainCompositions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        return id == train.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
