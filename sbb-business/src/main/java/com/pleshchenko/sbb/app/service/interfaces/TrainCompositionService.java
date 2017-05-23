package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.TrainComposition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 23.05.2017.
 */
@Service("trainCompositionService")
@Transactional
public interface TrainCompositionService {

    /**
     *
     * @return a list of all train compositions
     */
    List<TrainComposition> findAll();

    /**
     *
     * @param trainComposition
     */
    void deleteTrainComposition(TrainComposition trainComposition);
}
