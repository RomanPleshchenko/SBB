package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.schedule.RouteComposition;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.RouteCompositionDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Repository("routeComposition")
public class RouteCompositionDaoImpl extends AbstractDao<Integer,RouteComposition> implements RouteCompositionDao {
    @Override
    public List<RouteComposition> findAll() {
        List<RouteComposition> routeCompositions = getEntityManager()
                .createQuery("SELECT r FROM RouteComposition r")
                .getResultList();
        return routeCompositions;
    }

    @Override
    public void deleteRouteComposition(RouteComposition routeComposition) {
        delete(routeComposition);
    }


}
