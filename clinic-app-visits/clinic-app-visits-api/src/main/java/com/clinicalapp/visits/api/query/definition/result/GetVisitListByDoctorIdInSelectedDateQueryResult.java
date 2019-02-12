package com.clinicalapp.visits.api.query.definition.result;

import java.io.Serializable;
import java.util.Set;


public class GetVisitListByDoctorIdInSelectedDateQueryResult implements Serializable {

    private Set<GetVisitListByDoctorIdInSelectedDateQueryElement> visits;

    public GetVisitListByDoctorIdInSelectedDateQueryResult() {
    }

    public Set<GetVisitListByDoctorIdInSelectedDateQueryElement> getVisits() {
        return visits;
    }

    public void setVisits(Set<GetVisitListByDoctorIdInSelectedDateQueryElement> visits) {
        this.visits = visits;
    }
}
