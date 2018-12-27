package com.clinicapp.users.api.query.definition.doctor.result.worktime;

import java.io.Serializable;

public class WorkHoursQueryResult implements Serializable {

    private WorkDayQueryResult monday;

    private WorkDayQueryResult tuesday;

    private WorkDayQueryResult wednesday;

    private WorkDayQueryResult thursday;

    private WorkDayQueryResult friday;

    private WorkDayQueryResult saturday;

    private WorkDayQueryResult sunday;

    public WorkHoursQueryResult() {
    }

    public WorkDayQueryResult getMonday() {
        return monday;
    }

    public void setMonday(WorkDayQueryResult monday) {
        this.monday = monday;
    }

    public WorkDayQueryResult getTuesday() {
        return tuesday;
    }

    public void setTuesday(WorkDayQueryResult tuesday) {
        this.tuesday = tuesday;
    }

    public WorkDayQueryResult getWednesday() {
        return wednesday;
    }

    public void setWednesday(WorkDayQueryResult wednesday) {
        this.wednesday = wednesday;
    }

    public WorkDayQueryResult getThursday() {
        return thursday;
    }

    public void setThursday(WorkDayQueryResult thursday) {
        this.thursday = thursday;
    }

    public WorkDayQueryResult getFriday() {
        return friday;
    }

    public void setFriday(WorkDayQueryResult friday) {
        this.friday = friday;
    }

    public WorkDayQueryResult getSaturday() {
        return saturday;
    }

    public void setSaturday(WorkDayQueryResult saturday) {
        this.saturday = saturday;
    }

    public WorkDayQueryResult getSunday() {
        return sunday;
    }

    public void setSunday(WorkDayQueryResult sunday) {
        this.sunday = sunday;
    }
}
