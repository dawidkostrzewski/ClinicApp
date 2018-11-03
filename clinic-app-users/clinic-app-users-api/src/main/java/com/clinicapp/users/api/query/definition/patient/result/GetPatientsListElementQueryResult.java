package com.clinicapp.users.api.query.definition.patient.result;

import java.io.Serializable;
import java.util.UUID;

public class GetPatientsListElementQueryResult implements Serializable {

    private UUID id;

    private String identificationNumberType;

    private String getIdentificationNumberValue;

    private Long birthDate;

    private String phoneCC;

    private String phone;

    public GetPatientsListElementQueryResult() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdentificationNumberType() {
        return identificationNumberType;
    }

    public void setIdentificationNumberType(String identificationNumberType) {
        this.identificationNumberType = identificationNumberType;
    }

    public String getGetIdentificationNumberValue() {
        return getIdentificationNumberValue;
    }

    public void setGetIdentificationNumberValue(String getIdentificationNumberValue) {
        this.getIdentificationNumberValue = getIdentificationNumberValue;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneCC() {
        return phoneCC;
    }

    public void setPhoneCC(String phoneCC) {
        this.phoneCC = phoneCC;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
