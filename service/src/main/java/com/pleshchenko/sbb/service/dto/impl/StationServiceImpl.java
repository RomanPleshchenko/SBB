package com.pleshchenko.sbb.service.dto.impl;

import com.pleshchenko.sbb.model.entity.route.Station;
import com.pleshchenko.sbb.service.dao.interfaces.StationDao;
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

//    @Override
//    public List<Station> findByStation(String stationName) {
//        List<Station> stations = dao.findByStation(stationName);
//        return stations;
//    }
}
