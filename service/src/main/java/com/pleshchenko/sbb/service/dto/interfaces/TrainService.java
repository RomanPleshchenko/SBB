package com.pleshchenko.sbb.service.dto.interfaces;

import com.pleshchenko.sbb.model.entity.Train;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 05.04.2017.
 */
@Service("trainService")
@Transactional
public interface TrainService {

    List<Train> findAll() ;

    void deleteByNumber(String number);

    void saveTrain(Train train);

    Train findByNumber(String number);
}
