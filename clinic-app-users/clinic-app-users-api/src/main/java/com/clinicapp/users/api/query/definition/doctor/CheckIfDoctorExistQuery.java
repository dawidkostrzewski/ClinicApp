package com.clinicapp.users.api.query.definition.doctor;

import java.io.Serializable;
import java.util.UUID;

public class CheckIfDoctorExistQuery implements Serializable {

    private UUID doctorId;

    public CheckIfDoctorExistQuery(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }
}
