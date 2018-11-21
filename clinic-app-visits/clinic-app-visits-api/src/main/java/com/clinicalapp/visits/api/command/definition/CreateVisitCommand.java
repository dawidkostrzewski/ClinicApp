package com.clinicalapp.visits.api.command.definition;

import java.io.Serializable;
import java.util.UUID;

public class CreateVisitCommand implements Serializable {

    private UUID doctorId;

    private UUID patientId;

    private Long visitTime;

    private String description;

    public CreateVisitCommand() {
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public Long getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Long visitTime) {
        this.visitTime = visitTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
