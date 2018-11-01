package com.clinicapp.users.impl.command.datatypes.aggregate;

import com.clinicapp.users.impl.command.datatypes.entity.User;
import com.clinicapp.libs.constants.TableDefs;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Doctor")
public class Doctor extends User implements Serializable {

    @Column(name = TableDefs.ColumnNames.Doctor.SPECIALIZATION)
    private String specialization;

    @Column(name = TableDefs.ColumnNames.Doctor.WORKING_HOURS, columnDefinition="TEXT")
    private String workingHours;

    public Doctor() {
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }
}
