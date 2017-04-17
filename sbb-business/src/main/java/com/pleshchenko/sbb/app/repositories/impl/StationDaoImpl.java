package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.route.Station;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.StationDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
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

    @Override
    public Station findByName(String name) {

        Query query = getEntityManager()
                .createQuery("SELECT s FROM Station s " +
                        "WHERE s.name = :name ");
        query.setParameter("name",name);

        List<Station> stations = query.getResultList();
        if (stations.size()==0){
            return null;
        }else {
            return stations.get(0);
        }

    }

    @Override
    public Station findById(Integer id) {
        Station station = getByKey(id);
        return station;
    }
}
