package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.CarPrototypeComposition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Service("carPrototypeCompositionService")
@Transactional
public interface CarPrototypeCompositionService {
    List<CarPrototypeComposition> findAll();
}
