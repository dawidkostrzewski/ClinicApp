package com.clinicapp.users.api.command.definition.patient;

import java.io.Serializable;
import java.util.UUID;

public class CreatePatientCommand implements Serializable {

    private UUID doctorId;

    public CreatePatientCommand() {
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }
}
