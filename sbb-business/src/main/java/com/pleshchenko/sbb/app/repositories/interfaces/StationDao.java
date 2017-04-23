package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.segment.Station;

import java.util.List;

/**
 * Created by РОМАН on 07.04.2017.
 */
public interface StationDao {
    List<Station> findAll();

    void saveStation(Station station);

    Station findByName(String name);

    public Station findById(Integer id);
}
