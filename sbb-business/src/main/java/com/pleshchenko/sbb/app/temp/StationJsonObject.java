package com.pleshchenko.sbb.app.temp;

import com.pleshchenko.sbb.app.entity.schedule.Station;

import java.util.List;

public class StationJsonObject {

    int iTotalRecords;

    int iTotalDisplayRecords;

    String sEcho;

    String sColumns;

    List<Station> aaData;

    public int getiTotalRecords() {
	return iTotalRecords;
    }

    public void setiTotalRecords(int iTotalRecords) {
	this.iTotalRecords = iTotalRecords;
    }

    public int getiTotalDisplayRecords() {
	return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
	this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public String getsEcho() {
	return sEcho;
    }

    public void setsEcho(String sEcho) {
	this.sEcho = sEcho;
    }

    public String getsColumns() {
	return sColumns;
    }

    public void setsColumns(String sColumns) {
	this.sColumns = sColumns;
    }

    public List<Station> getAaData() {
        return aaData;
    }

    public void setAaData(List<Station> aaData) {
        this.aaData = aaData;
    }

    
}
