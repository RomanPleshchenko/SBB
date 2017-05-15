package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.Train;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 05.04.2017.
 */
@Service("trainService")
@Transactional
public interface TrainService {

    /**
     *
     * @return a list of all train
     */
    List<Train> findAll() ;

    /**
     *
     * @param number of train
     */
    void deleteByNumber(String number);

    /**
     * save train in DB
     * @param train
     */
    void saveTrain(Train train);

    /**
     *
     * @param number of train
     * @return a train by number
     */
    Train findByNumber(String number);

    /**
     *
     * @param id of train
     * @return a train by id
     */
    Train findById(Integer id);
}
