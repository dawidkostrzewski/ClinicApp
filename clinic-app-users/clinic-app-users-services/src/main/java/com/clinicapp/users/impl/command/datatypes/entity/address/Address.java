package com.clinicapp.users.impl.command.datatypes.entity.address;

import com.clinicapp.users.impl.command.datatypes.aggregate.Patient;
import com.clinicapp.libs.constants.TableDefs;
import com.clinicapp.libs.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = TableDefs.TablesNames.ADDRESS)
public class Address extends BaseEntity implements Serializable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = TableDefs.ColumnNames.PATIENT_ID)
    private Patient patient;

    @Column(name = TableDefs.ColumnNames.Address.CITY)
    private String city;

    @Column(name = TableDefs.ColumnNames.Address.STREET)
    private String street;

    @Column(name = TableDefs.ColumnNames.Address.HOUSE_NUBER)
    private String houseNumber;

    @Column(name = TableDefs.ColumnNames.Address.FLAT_NUMBER)
    private String flatNumber;

    public Address() {
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
}
