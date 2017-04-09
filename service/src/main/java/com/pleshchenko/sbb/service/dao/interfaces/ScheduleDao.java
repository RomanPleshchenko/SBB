package com.pleshchenko.sbb.service.dao.interfaces;

import com.pleshchenko.sbb.model.entity.route.Schedule;
import com.pleshchenko.sbb.service.dto.other.ParametersForSearch;

import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
public interface ScheduleDao {

    Schedule findById(Integer id);

    List<Schedule> findAll();

    List<Schedule> findByParameters(ParametersForSearch param);
}
