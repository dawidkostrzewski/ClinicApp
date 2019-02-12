package com.clinicapp.users.api.query.definition.doctor.query;

import java.io.Serializable;
import java.util.UUID;

public class GetDoctorWorkTimesForSelectedDateQuery implements Serializable {

    private UUID doctorId;

    private Long date;

    public GetDoctorWorkTimesForSelectedDateQuery() {
    }

    public GetDoctorWorkTimesForSelectedDateQuery(UUID doctorId, Long date) {
        this.doctorId = doctorId;
        this.date = date;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
