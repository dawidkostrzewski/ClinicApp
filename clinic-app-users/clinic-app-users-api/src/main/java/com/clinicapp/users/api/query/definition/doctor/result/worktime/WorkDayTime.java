package com.clinicapp.users.api.query.definition.doctor.result.worktime;

import java.io.Serializable;

public class WorkDayTime implements Serializable {

    private int minutes;

    private int hours;

    public WorkDayTime() {
    }

    public WorkDayTime(int minutes, int hours) {
        this.minutes = minutes;
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
