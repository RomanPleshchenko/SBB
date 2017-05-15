package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Segment;
import com.pleshchenko.sbb.app.entity.schedule.Station;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 13.04.2017.
 */
@Service("segmentService")
@Transactional
public interface SegmentService {
    Segment findByStation(Station departureStation, Station destinationStation, boolean createNew);

    /**
     *
     * @return a list of ol segments
     */
    List<Segment> findAll();
}
