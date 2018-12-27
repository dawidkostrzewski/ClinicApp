package com.clinicalapp.visits.api.query.definition.query;


import java.util.UUID;

public class GetVisitsForSelectedDateQuery {

    private UUID patientId;

    private UUID doctorId;

    private Long visitTime;

    public GetVisitsForSelectedDateQuery() {
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public Long getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Long visitTime) {
        this.visitTime = visitTime;
    }
}
