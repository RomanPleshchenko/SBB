package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Segment;
import com.pleshchenko.sbb.app.entity.schedule.Station;

import java.util.List;

/**
 * Created by РОМАН on 13.04.2017.
 */
public interface SegmentDao {

    Segment findByStation(Station departureStation, Station destinationStation, boolean createNew);

    List<Segment> findAll();
}
