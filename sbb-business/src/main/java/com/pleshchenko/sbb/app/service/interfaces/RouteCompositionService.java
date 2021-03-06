package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.RouteComposition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Service("routeCompositionService")
@Transactional
public interface RouteCompositionService {
    /**
     *
     * @return a list of all route compositions
     */
    List<RouteComposition> findAll();

    /**
     *
     * @param routeComposition
     */
    void deleteRouteComposition(RouteComposition routeComposition);
}
