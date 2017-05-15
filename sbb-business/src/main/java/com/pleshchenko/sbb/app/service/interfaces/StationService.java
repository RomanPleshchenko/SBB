package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Station;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by РОМАН on 07.04.2017.
 */
@Service("stationService")
@Transactional
public interface StationService {

    /**
     *
     * @return a list of all station
     */
    List<Station> findAll();

    /**
     *
     * @param pageNumber
     * @param searchParameter name or fragment of name station
     * @param pageDisplayLength
     * @return
     */
    public List<Station> findAll(Integer pageNumber,String searchParameter,Integer pageDisplayLength);

    /**
     *
     * @param station save station in DB
     */
    void saveStation(Station station);

    /**
     *
     * @param name
     * @return
     */
    Station findByName(String name);

    /**
     *
     * @param id of station
     * @return station by id
     */
    public Station findById(Integer id);

    /**
     *
     * @return a cout of all stations
     */
    Long getCount();

}
