package com.pleshchenko.sbb.service.dto.impl;

import com.pleshchenko.sbb.model.entity.route.Station;
import com.pleshchenko.sbb.service.repositories.interfaces.StationDao;
import com.pleshchenko.sbb.service.dto.interfaces.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 07.04.2017.
 */
@Service("stationService")
@Transactional
public class StationServiceImpl implements StationService {

    @Autowired
    private StationDao dao;

    @Override
    public List<Station> findAll() {
        List<Station> station = dao.findAll();
        return station;
    }

    @Override
    public void saveStation(Station station) {
        dao.saveStation(station);
    }

    @Override
    public Station findByName(String name) {
        Station station = dao.findByName(name);
        return station;
    }

    @Override
    public Station findById(Integer id) {
        Station station = dao.findById(id);
        return station;
    }

}
