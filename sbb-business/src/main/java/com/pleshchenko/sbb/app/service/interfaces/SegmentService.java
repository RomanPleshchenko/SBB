package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.segment.Segment;
import com.pleshchenko.sbb.app.entity.segment.Station;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by РОМАН on 13.04.2017.
 */
@Service("segmentService")
@Transactional
public interface SegmentService {
    Segment findByStation(Station departureStation, Station destinationStation, boolean createNew);
}
