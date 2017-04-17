package com.pleshchenko.sbb.app.service.other;

import java.sql.Date;

/**
 * Created by РОМАН on 07.04.2017.
 */

public class ParametersForSearch {
    private Date data1;
    private Date data2;
    private Integer station1;
    private Integer station2;
    private String train;

    public Date getData1() {
        return data1;
    }

    public void setData1(Date data1) {
        this.data1 = data1;
    }

    public Date getData2() {
        return data2;
    }

    public void setData2(Date data2) {
        this.data2 = data2;
    }

    public Integer getStation1() {
        return station1;
    }

    public void setStation1(Integer station1) {
        this.station1 = station1;
    }

    public Integer getStation2() {
        return station2;
    }

    public void setStation2(Integer station2) {
        this.station2 = station2;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }
}
