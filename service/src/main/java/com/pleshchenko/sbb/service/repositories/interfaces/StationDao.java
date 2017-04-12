package com.pleshchenko.sbb.service.repositories.interfaces;

import com.pleshchenko.sbb.model.entity.route.Station;

import java.util.List;

/**
 * Created by РОМАН on 07.04.2017.
 */
public interface StationDao {
    List<Station> findAll();

    void saveStation(Station station);

//    List<Station> findByStation(String stationName);
}
