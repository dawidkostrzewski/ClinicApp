package com.clinicapp.users.api.query.definition.doctor.query;

import java.io.Serializable;
import java.util.UUID;

public class GetDoctorWorkTimesQuery implements Serializable {

    private UUID doctorId;

    public GetDoctorWorkTimesQuery(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }
}
