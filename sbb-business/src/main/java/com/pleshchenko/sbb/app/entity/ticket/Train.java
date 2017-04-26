package com.pleshchenko.sbb.app.entity.ticket;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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

    @NotNull
    @Min(1)
    @Column(name = "capacity")
    private int capacity;

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
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (id != train.id) return false;
        if (capacity != train.capacity) return false;
        if (number != null ? !number.equals(train.number) : train.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + capacity;
        return result;
    }
}
