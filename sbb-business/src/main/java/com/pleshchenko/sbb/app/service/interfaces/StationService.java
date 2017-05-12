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

    List<Station> findAll();

    public List<Station> findAll(Integer pageNumber,String searchParameter,Integer pageDisplayLength);

    void saveStation(Station station);

    Station findByName(String name);

    public Station findById(Integer id);

    Long getCount();

}
