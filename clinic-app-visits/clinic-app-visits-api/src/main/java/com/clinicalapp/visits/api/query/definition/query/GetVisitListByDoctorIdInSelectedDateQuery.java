package com.clinicalapp.visits.api.query.definition.query;

import java.io.Serializable;
import java.util.UUID;

public class GetVisitListByDoctorIdInSelectedDateQuery implements Serializable {

    private UUID doctorId;

    private Long selectedDate;

    public GetVisitListByDoctorIdInSelectedDateQuery() {
    }

    public GetVisitListByDoctorIdInSelectedDateQuery(UUID doctorId, Long selectedDate) {
        this.doctorId = doctorId;
        this.selectedDate = selectedDate;
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
