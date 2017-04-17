package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.route.Route;
import com.pleshchenko.sbb.app.entity.route.Station;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.RouteDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by РОМАН on 13.04.2017.
 */
@Service("routeDao")
@Transactional
public class RouteDaoImpl extends AbstractDao<Integer,Route> implements RouteDao {

    @Override
    public Route findByStation(Station departureStation, Station destinationStation, boolean createNew) {
        Query query = getEntityManager()
                .createQuery("SELECT r FROM Route r " +
                        "WHERE r.departureStation = :departureStation AND r.destinationStation = :destinationStation");
        query.setParameter("departureStation",departureStation);
        query.setParameter("destinationStation",destinationStation);

        List<Route> routes = query.getResultList();
        if (routes.size()==0){

            if (createNew){

                Route route = new Route(departureStation,destinationStation);
                getEntityManager().persist(route);
                getEntityManager().flush();

                return route;
            }

            return null;
        }else {
            return routes.get(0);
        }
    }
}
