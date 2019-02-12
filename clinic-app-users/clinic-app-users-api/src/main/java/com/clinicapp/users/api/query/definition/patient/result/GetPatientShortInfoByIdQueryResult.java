package com.clinicapp.users.api.query.definition.patient.result;

import java.io.Serializable;
import java.util.UUID;


public class GetPatientShortInfoByIdQueryResult implements Serializable {

    private UUID id;

    private String firstName;

    private String familyName;

    private String identificationNumberType;

    private String identificationNumberValue;

    public GetPatientShortInfoByIdQueryResult() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getIdentificationNumberType() {
        return identificationNumberType;
    }

    public void setIdentificationNumberType(String identificationNumberType) {
        this.identificationNumberType = identificationNumberType;
    }

    public String getIdentificationNumberValue() {
        return identificationNumberValue;
    }

    public void setIdentificationNumberValue(String identificationNumberValue) {
        this.identificationNumberValue = identificationNumberValue;
    }
}
