package com.clinicapp.users.api.query.definition.doctor.result;

import com.clinicapp.users.api.query.definition.doctor.result.worktime.WorkDayQueryResult;

import java.io.Serializable;

public class GetDoctorWorkTimesForSelectedDateQueryResult implements Serializable {

    private WorkDayQueryResult workDayQueryResult;

    public GetDoctorWorkTimesForSelectedDateQueryResult() {
    }

    public WorkDayQueryResult getWorkDayQueryResult() {
        return workDayQueryResult;
    }

    public void setWorkDayQueryResult(WorkDayQueryResult workDayQueryResult) {
        this.workDayQueryResult = workDayQueryResult;
    }
}
