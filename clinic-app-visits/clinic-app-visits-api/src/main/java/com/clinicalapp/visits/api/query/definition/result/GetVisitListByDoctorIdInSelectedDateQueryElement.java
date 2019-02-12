package com.clinicalapp.visits.api.query.definition.result;


import java.io.Serializable;
import java.util.UUID;

public class GetVisitListByDoctorIdInSelectedDateQueryElement implements Serializable {

    private String patientName;

    private String patientIdentificationNumber;

    private UUID patientId;

    private UUID visitId;

    private Long visitTime;

    private Boolean finished;

    public GetVisitListByDoctorIdInSelectedDateQueryElement() {
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientIdentificationNumber() {
        return patientIdentificationNumber;
    }

    public void setPatientIdentificationNumber(String patientIdentificationNumber) {
        this.patientIdentificationNumber = patientIdentificationNumber;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getVisitId() {
        return visitId;
    }

    public void setVisitId(UUID visitId) {
        this.visitId = visitId;
    }

    public Long getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Long visitTime) {
        this.visitTime = visitTime;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
