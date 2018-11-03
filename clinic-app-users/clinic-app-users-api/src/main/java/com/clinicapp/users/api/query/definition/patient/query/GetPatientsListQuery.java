package com.clinicapp.users.api.query.definition.patient.query;

import java.io.Serializable;
import java.util.UUID;

public class GetPatientsListQuery implements Serializable {

    private UUID doctorId;

    private int limit;

    private int offset;

    public GetPatientsListQuery(UUID doctorId, int limit, int offset) {
        this.doctorId = doctorId;
        this.limit = limit;
        this.offset = offset;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
