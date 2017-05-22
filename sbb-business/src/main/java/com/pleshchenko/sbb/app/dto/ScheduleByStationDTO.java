package com.pleshchenko.sbb.app.dto;

import com.pleshchenko.sbb.app.entity.schedule.RouteComposition;
import com.pleshchenko.sbb.app.entity.schedule.Schedule;

import java.time.Instant;
import java.util.Set;

/**
 * Created by РОМАН on 19.05.2017.
 */
public class ScheduleByStationDTO {

    private int id;

    private String trainNumber;

    private String routeName;

    private String destinationTime;

    private String departureTime;

    private String stopTime;

    public ScheduleByStationDTO() {
    }

    public ScheduleByStationDTO(Schedule schedule,String stationsName) {

        this.trainNumber = schedule.getTrain().getNumber();
        this.routeName = schedule.getRoute().getName();
        this.id = schedule.getId();

        this.departureTime = "";
        this.destinationTime = "";
        int destinationTimeInMinute = 0;
        int departureTimeInMinute = 0;

        Set<RouteComposition> routeCompositionSet = schedule.getRoute().getRouteCompositions();
        for (RouteComposition routeComposition : routeCompositionSet) {

            if (routeComposition.getSegment().getDepartureStation().getName().equalsIgnoreCase(stationsName)) {
                departureTimeInMinute = routeComposition.getDepartureTime();
                this.departureTime = instantToString(schedule.getDepartureTime().plusSeconds(departureTimeInMinute*60));
            }

            if (routeComposition.getSegment().getDestinationStation().getName().equalsIgnoreCase(stationsName)) {
                destinationTimeInMinute = routeComposition.getDestinationTime();
                this.destinationTime = instantToString(schedule.getDepartureTime().plusSeconds(destinationTimeInMinute*60));
            }
        }

        if (this.departureTime != "" && this.destinationTime != "") {
            this.stopTime = "" + (departureTimeInMinute - destinationTimeInMinute);
        } else{
            this.stopTime = "-";
        }
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(String destinationTime) {
        this.destinationTime = destinationTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleByStationDTO that = (ScheduleByStationDTO) o;

        if (!trainNumber.equals(that.trainNumber)) return false;
        return routeName.equals(that.routeName);
    }

    @Override
    public int hashCode() {
        int result = trainNumber.hashCode();
        result = 31 * result + routeName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ScheduleByStationDTO{" +
                "id='" + id + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", routeName='" + routeName + '\'' +
                ", destinationTime='" + destinationTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", stopTime='" + stopTime + '\'' +
                '}';
    }

    private String instantToString(Instant instant){

        String date = instant.plusSeconds(3*3600).toString().replace("T"," ").replace("Z","");
        return date;

    }

}
