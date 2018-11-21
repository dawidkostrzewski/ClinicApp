package com.clinicapp.users.api.query.definition.doctor.result;

import com.clinicapp.users.api.query.definition.doctor.result.worktime.WorkHours;

import java.io.Serializable;

public class GetDoctorWorkTimesQueryResult implements Serializable {

    private WorkHours workHours;

    public GetDoctorWorkTimesQueryResult() {
    }

    public WorkHours getWorkHours() {
        return workHours;
    }

    public void setWorkHours(WorkHours workHours) {
        this.workHours = workHours;
    }
}
