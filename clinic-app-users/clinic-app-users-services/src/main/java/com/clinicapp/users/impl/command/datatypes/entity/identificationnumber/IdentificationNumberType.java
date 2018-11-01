package com.clinicapp.users.impl.command.datatypes.entity.identificationnumber;

import com.clinicapp.libs.constants.TableDefs;
import com.clinicapp.libs.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = TableDefs.TablesNames.IDENTIFICATION_NUMBER_TYPE)
public class IdentificationNumberType extends BaseEntity implements Serializable {

    @Column(name = TableDefs.ColumnNames.IdentificationNumberType.VALUE)
    private String value;

    @Column(name = TableDefs.ColumnNames.IdentificationNumberType.VALIDATOR)
    private String validator;

    public IdentificationNumberType() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValidator() {
        return validator;
    }

    public void setValidator(String validator) {
        this.validator = validator;
    }
}
