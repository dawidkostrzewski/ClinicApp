package com.clinicapp.users.api.query.definition.doctor.result.worktime;

import java.io.Serializable;

public class WorkDayQueryResult implements Serializable {

    private WorkDayTimeQueryResult startTime;

    private WorkDayTimeQueryResult endTime;

    private WorkDayTimeQueryResult breakStartTime;

    private WorkDayTimeQueryResult breakEndTime;

    public WorkDayQueryResult() {
    }

    public WorkDayTimeQueryResult getStartTime() {
        return startTime;
    }

    public void setStartTime(WorkDayTimeQueryResult startTime) {
        this.startTime = startTime;
    }

    public WorkDayTimeQueryResult getEndTime() {
        return endTime;
    }

    public void setEndTime(WorkDayTimeQueryResult endTime) {
        this.endTime = endTime;
    }

    public WorkDayTimeQueryResult getBreakStartTime() {
        return breakStartTime;
    }

    public void setBreakStartTime(WorkDayTimeQueryResult breakStartTime) {
        this.breakStartTime = breakStartTime;
    }

    public WorkDayTimeQueryResult getBreakEndTime() {
        return breakEndTime;
    }

    public void setBreakEndTime(WorkDayTimeQueryResult breakEndTime) {
        this.breakEndTime = breakEndTime;
    }
}
