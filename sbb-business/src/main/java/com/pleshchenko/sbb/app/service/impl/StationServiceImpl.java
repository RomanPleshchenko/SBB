package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.schedule.Station;
import com.pleshchenko.sbb.app.repositories.interfaces.StationDao;
import com.pleshchenko.sbb.app.service.interfaces.StationService;
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
        List<Station> stations = dao.findAll();
        return stations;
    }

    public List<Station> findAll(Integer pageNumber,String searchParameter,Integer pageDisplayLength){
        List<Station> stations = dao.findAll(pageNumber,searchParameter,pageDisplayLength);
        return stations;
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

    @Override
    public Long getCount() {
        Long count = dao.getCount();
        return count;
    }

}
