package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.segment.Segment;
import com.pleshchenko.sbb.app.entity.segment.Station;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.repositories.interfaces.SegmentDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by РОМАН on 13.04.2017.
 */
@Service("segmentDao")
@Transactional
public class SegmentDaoImpl extends AbstractDao<Integer,Segment> implements SegmentDao {

    @Override
    public Segment findByStation(Station departureStation, Station destinationStation, boolean createNew) {
        Query query = getEntityManager()
                .createQuery("SELECT r FROM Segment r " +
                        "WHERE r.departureStation = :departureStation AND r.destinationStation = :destinationStation");
        query.setParameter("departureStation",departureStation);
        query.setParameter("destinationStation",destinationStation);

        List<Segment> segments = query.getResultList();
        if (segments.size()==0){

            if (createNew){

                Segment segment = new Segment(departureStation,destinationStation);
                getEntityManager().persist(segment);
                getEntityManager().flush();

                return segment;
            }

            return null;
        }else {
            return segments.get(0);
        }
    }
}
