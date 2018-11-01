package com.clinicapp.users.impl.command.datatypes.entity.identificationnumber;

import com.clinicapp.users.impl.command.datatypes.aggregate.Patient;
import com.clinicapp.libs.constants.TableDefs;
import com.clinicapp.libs.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = TableDefs.TablesNames.IDENTIFICATION_NUMBER)
public class IdentificationNumber extends BaseEntity implements Serializable {

    @Column(name = TableDefs.ColumnNames.IdentificationNumber.VALUE)
    private String value;

    @Column(name = TableDefs.ColumnNames.IdentificationNumber.TYPE)
    private UUID type;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = TableDefs.ColumnNames.PATIENT_ID)
    private Patient patient;

    public IdentificationNumber() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UUID getType() {
        return type;
    }

    public void setType(UUID type) {
        this.type = type;
    }
}
