package com.pleshchenko.sbb.model.model.otherClasses;

import java.sql.Timestamp;

/**
 * Created by РОМАН on 07.04.2017.
 */
public class ParametersForSearch {
    private Timestamp data1;
    private Timestamp data2;
    private String station1;
    private String station2;

    public Timestamp getData1() {
        return data1;
    }

    public void setData1(Timestamp data1) {
        this.data1 = data1;
    }

    public Timestamp getData2() {
        return data2;
    }

    public void setData2(Timestamp data2) {
        this.data2 = data2;
    }

    public String getStation1() {
        return station1;
    }

    public void setStation1(String station1) {
        this.station1 = station1;
    }

    public String getStation2() {
        return station2;
    }

    public void setStation2(String station2) {
        this.station2 = station2;
    }
}
