package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.segment.Segment;
import com.pleshchenko.sbb.app.entity.segment.Station;

/**
 * Created by РОМАН on 13.04.2017.
 */
public interface SegmentDao {

    Segment findByStation(Station departureStation, Station destinationStation, boolean createNew);
}
