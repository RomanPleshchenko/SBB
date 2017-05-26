package com.pleshchenko.sbb.app.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by РОМАН on 26.05.2017.
 */
public class MessageDTO {

    private String action;
    private Integer scheduleId;
    private String stationsName;

    public MessageDTO() {
    }

    public MessageDTO(String action, Integer scheduleId, String stationsName) {
        this.action = action;
        this.scheduleId = scheduleId;
        this.stationsName = stationsName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getStationsName() {
        return stationsName;
    }

    public void setStationsName(String stationsName) {
        this.stationsName = stationsName;
    }
}
