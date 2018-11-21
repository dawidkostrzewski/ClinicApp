package com.clinicapp.users.api.query.definition.patient.query;


import java.io.Serializable;
import java.util.UUID;

public class CheckIfPatientExistQuery implements Serializable {

    private UUID patientId;

    public CheckIfPatientExistQuery(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }
}
