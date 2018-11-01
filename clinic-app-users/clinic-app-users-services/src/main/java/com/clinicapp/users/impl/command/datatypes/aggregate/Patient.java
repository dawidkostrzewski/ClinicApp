package com.clinicapp.users.impl.command.datatypes.aggregate;


import com.clinicapp.users.impl.command.datatypes.entity.User;
import com.clinicapp.users.impl.command.datatypes.entity.address.Address;
import com.clinicapp.users.impl.command.datatypes.entity.identificationnumber.IdentificationNumber;
import com.clinicapp.libs.constants.Sex;
import com.clinicapp.libs.constants.TableDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@DiscriminatorValue("Patient")
public class Patient extends User implements Serializable {

    @Enumerated(EnumType.ORDINAL)
    private Sex sex;

    @Column(name = TableDefs.ColumnNames.User.BIRTH_DATE)
    private Long birthDate;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private IdentificationNumber identificationNumber;

    @Column(name = TableDefs.ColumnNames.Patient.PATIENT_PHONE)
    private String patientPhone;

    @Column(name = TableDefs.ColumnNames.Patient.PATIENT_PHONE_CC)
    private String patientPhoneCC;

    @Column(name = TableDefs.ColumnNames.Patient.CONTACT_PHONE_CC)
    private String contactPhoneCC;

    @Column(name = TableDefs.ColumnNames.Patient.CONTACT_PHONE)
    private String contactPhone;

    @Column(name = TableDefs.ColumnNames.DOCTOR_ID)
    private UUID doctorId;

    public Patient() {
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public IdentificationNumber getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(IdentificationNumber identificationNumber) {
        this.identificationNumber = identificationNumber;
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

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }
}
