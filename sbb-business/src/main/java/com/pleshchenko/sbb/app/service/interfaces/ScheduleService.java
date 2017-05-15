package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
 * Created by РОМАН on 06.04.2017.
 */
@Service("scheduleService")
@Transactional
public interface ScheduleService {

    /**
     *
     * @return a schedule by id
     */
    Schedule findById(Integer id);

    /**
     *
     * @return a list of schedule
     */
    List<Schedule> findAll();

    /**
     *
     * @return a schedule in JSON
     */
    String getScheduleJSONByParameters(int st1, int st2, Date data1, Date data2);

    /**
     * @return a free site by parameters
     *
     * @param st1 id of departure station
     * @param st2 id of destination station
     * @param dirId id of schedule
     * @param routeId id of route
     */
    public List findFreeSite(int st1,int st2,int dirId,int routeId);

    /**
     * @return a schedule by station name
     *
     * @param stationName name of departure station
     *
     */
    List<Schedule> findByStation(String stationName);

    /**
     * make schedule active and visible for searh ticket
     * @param id id of schedule
     */
    void makeActive(int id);

    /**
     * make schedule not active and unvisible for searh ticket
     * @param id id of schedule
     */
    public void makeNotActive(int id);

    /**
     * compose free sites for schedule
     * @param id id of schedule
     */
    public void composeFreeSites(int id);



}
