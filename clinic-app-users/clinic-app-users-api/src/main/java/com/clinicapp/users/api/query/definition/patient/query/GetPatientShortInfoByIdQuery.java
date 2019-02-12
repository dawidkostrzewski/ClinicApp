package com.clinicapp.users.api.query.definition.patient.query;


import java.io.Serializable;
import java.util.UUID;

public class GetPatientShortInfoByIdQuery implements Serializable {

    private UUID patientId;

    public GetPatientShortInfoByIdQuery(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }
}
