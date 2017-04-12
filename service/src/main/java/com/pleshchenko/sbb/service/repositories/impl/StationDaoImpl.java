package com.pleshchenko.sbb.service.repositories.impl;

import com.pleshchenko.sbb.model.entity.route.Station;
import com.pleshchenko.sbb.service.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.service.repositories.interfaces.StationDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by РОМАН on 07.04.2017.
 */
@Repository("stationDao")
public class StationDaoImpl extends AbstractDao<Integer,Station> implements StationDao {
    @Override
    public List<Station> findAll() {
        List<Station> stations = getEntityManager()
                .createQuery("SELECT s FROM Station s ORDER BY s.name ASC")
                .getResultList();
        return stations;
    }

    @Override
    public void saveStation(Station station) {
        persist(station);
    }

//    @Override
//    public List<Station> findByStation(String stationName) {
//        List<Station> trains = getEntityManager()
//                .createQuery("SELECT s FROM Station s ORDER BY s.name WHERE s.name = " + stationName +" ASC")
//                .getResultList();
//        return trains;
//    }
}
