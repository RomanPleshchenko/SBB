package com.pleshchenko.sbb.app.service.impl;

import com.pleshchenko.sbb.app.entity.segment.Segment;
import com.pleshchenko.sbb.app.entity.segment.Station;
import com.pleshchenko.sbb.app.service.interfaces.SegmentService;
import com.pleshchenko.sbb.app.repositories.interfaces.SegmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by РОМАН on 13.04.2017.
 */
@Service("segmentService")
@Transactional
public class SegmentServiceImpl implements SegmentService {

    @Autowired
    SegmentDao dao;
    @Override
    public Segment findByStation(Station departureStation, Station destinationStation, boolean createNew) {
        Segment segment = dao.findByStation(departureStation,destinationStation,createNew);
        return segment;
    }
}
