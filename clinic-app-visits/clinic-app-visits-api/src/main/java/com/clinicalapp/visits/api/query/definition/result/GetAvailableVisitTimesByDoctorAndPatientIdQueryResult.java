package com.clinicalapp.visits.api.query.definition.result;

import java.io.Serializable;
import java.util.Set;

public class GetAvailableVisitTimesByDoctorAndPatientIdQueryResult implements Serializable {

    private Set<Long> availableVisitTimes;

    public GetAvailableVisitTimesByDoctorAndPatientIdQueryResult() {
    }

    public Set<Long> getAvailableVisitTimes() {
        return availableVisitTimes;
    }

    public void setAvailableVisitTimes(Set<Long> availableVisitTimes) {
        this.availableVisitTimes = availableVisitTimes;
    }
}
