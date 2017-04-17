package com.pleshchenko.sbb.model.service.interfaces;

import com.pleshchenko.sbb.model.entity.route.Schedule;
import com.pleshchenko.sbb.model.service.other.ParametersForSearch;
import com.pleshchenko.sbb.model.repositories.exceptions.NotEnoughParamsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
@Service("scheduleService")
@Transactional
public interface ScheduleService {

    Schedule findById(Integer id);

    List<Schedule> findAll();

    List<Schedule> findByStation(String stationName);

    List<Schedule> findByParameters(ParametersForSearch param);

    Schedule addByParameters(ParametersForSearch param) throws NotEnoughParamsException;

}
