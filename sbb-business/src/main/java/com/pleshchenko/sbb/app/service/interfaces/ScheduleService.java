package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.service.other.ParametersForSearch;
import com.pleshchenko.sbb.app.repositories.exceptions.NotEnoughParamsException;
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

//    List<Schedule> findByParameters(ParametersForSearch param);
//
//    Schedule addByParameters(ParametersForSearch param) throws NotEnoughParamsException;

}
