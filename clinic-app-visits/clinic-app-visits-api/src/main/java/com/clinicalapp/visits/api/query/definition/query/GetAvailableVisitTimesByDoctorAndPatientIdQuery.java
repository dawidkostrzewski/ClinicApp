package com.clinicalapp.visits.api.query.definition.query;


import java.io.Serializable;
import java.util.UUID;

public class GetAvailableVisitTimesByDoctorAndPatientIdQuery implements Serializable {

    private UUID patientId;

    private UUID doctorId;

    private Long selectedDate;

    public GetAvailableVisitTimesByDoctorAndPatientIdQuery() {
    }

    public GetAvailableVisitTimesByDoctorAndPatientIdQuery(UUID patientId, UUID doctorId, Long selectedDate) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.selectedDate = selectedDate;
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

    public Long getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Long selectedDate) {
        this.selectedDate = selectedDate;
    }
}
