package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.CarPrototypeComposition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("carPrototypeCompositionService")
@Transactional
public interface CarPrototypeCompositionService {

    /**
     *
     * @return a list of all car prototype pomposition
     */
    List<CarPrototypeComposition> findAll();

}
