package com.clinicapp.users.api.command.definition.patient;

import com.clinicapp.libs.constants.Sex;

import java.io.Serializable;
import java.util.UUID;

public class CreatePatientCommand implements Serializable {

    private UUID doctorId;

    private String firstName;

    private String familyName;

    private Sex sex;

    private String email;

    private Long birthDate;

    private String city;

    private String street;

    private String houseNumber;

    private String flatNumber;

    private UUID identificationNumberTypeId;

    private String identificationNumberValue;

    private String patientPhone;

    private String patientPhoneCC;

    private String contactPhoneCC;

    private String contactPhone;

    public CreatePatientCommand() {
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public UUID getIdentificationNumberType() {
        return identificationNumberTypeId;
    }

    public void setIdentificationNumberType(UUID identificationNumberTypeId) {
        this.identificationNumberTypeId = identificationNumberTypeId;
    }

    public String getIdentificationNumberValue() {
        return identificationNumberValue;
    }

    public void setIdentificationNumberValue(String identificationNumberValue) {
        this.identificationNumberValue = identificationNumberValue;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientPhoneCC() {
        return patientPhoneCC;
    }

    public void setPatientPhoneCC(String patientPhoneCC) {
        this.patientPhoneCC = patientPhoneCC;
    }

    public String getContactPhoneCC() {
        return contactPhoneCC;
    }

    public void setContactPhoneCC(String contactPhoneCC) {
        this.contactPhoneCC = contactPhoneCC;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
