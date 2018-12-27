package com.clinicalapp.visits.api.query.definition.result;

import java.io.Serializable;

public class GetVisitsForSelectedDateItemQueryResult implements Serializable {

    private Long visitTime;

    public Long getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Long visitTime) {
        this.visitTime = visitTime;
    }

    public GetVisitsForSelectedDateItemQueryResult(Long visitTime) {
        this.visitTime = visitTime;
    }
}
