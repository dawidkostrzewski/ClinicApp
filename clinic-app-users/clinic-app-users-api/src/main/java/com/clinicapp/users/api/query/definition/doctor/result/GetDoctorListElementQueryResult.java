package com.clinicapp.users.api.query.definition.doctor.result;

import java.io.Serializable;
import java.util.UUID;

public class GetDoctorListElementQueryResult implements Serializable {

    private UUID id;

    private String name;

    private String specialization;

    public GetDoctorListElementQueryResult() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
