package com.clinicalapp.visits.api.query.definition.query;

import java.io.Serializable;
import java.util.UUID;

public class GetPatientVisitsHistoryQuery implements Serializable {

    private UUID patientId;

    private int offset;

    private int limit;

    public GetPatientVisitsHistoryQuery() {
    }

    public GetPatientVisitsHistoryQuery(UUID patientId, int offset, int limit) {
        this.patientId = patientId;
        this.offset = offset;
        this.limit = limit;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
