package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Station;

import java.util.List;

/**
 * Created by РОМАН on 07.04.2017.
 */
public interface StationDao {
    List<Station> findAll();

    List<Station> findAll(Integer pageNumber,String searchParameter,Integer pageDisplayLength);

    void saveStation(Station station);

    Station findByName(String name);

    Station findById(Integer id);

    Long getCount();
}
