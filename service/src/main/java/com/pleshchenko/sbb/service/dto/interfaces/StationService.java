package com.pleshchenko.sbb.service.dto.interfaces;

import com.pleshchenko.sbb.model.entity.route.Schedule;
import com.pleshchenko.sbb.model.entity.route.Station;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 07.04.2017.
 */
@Service("stationService")
@Transactional
public interface StationService {
    List<Station> findAll();

    void saveStation(Station station);

    Station findByName(String name);

    public Station findById(Integer id);

}
