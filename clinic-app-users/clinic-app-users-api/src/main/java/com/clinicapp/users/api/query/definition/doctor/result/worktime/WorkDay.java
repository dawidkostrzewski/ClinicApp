package com.clinicapp.users.api.query.definition.doctor.result.worktime;

import java.io.Serializable;

public class WorkDay implements Serializable {

    private WorkDayTime startTime;

    private WorkDayTime endTime;

    private WorkDayTime breakStartTime;

    private WorkDayTime breakEndTime;

    public WorkDay() {
    }

    public WorkDayTime getStartTime() {
        return startTime;
    }

    public void setStartTime(WorkDayTime startTime) {
        this.startTime = startTime;
    }

    public WorkDayTime getEndTime() {
        return endTime;
    }

    public void setEndTime(WorkDayTime endTime) {
        this.endTime = endTime;
    }

    public WorkDayTime getBreakStartTime() {
        return breakStartTime;
    }

    public void setBreakStartTime(WorkDayTime breakStartTime) {
        this.breakStartTime = breakStartTime;
    }

    public WorkDayTime getBreakEndTime() {
        return breakEndTime;
    }

    public void setBreakEndTime(WorkDayTime breakEndTime) {
        this.breakEndTime = breakEndTime;
    }
}
