package com.clinicapp.users.impl.command.datatypes.aggregate;

import com.clinicapp.users.impl.command.datatypes.QueryTokens;
import com.clinicapp.users.impl.command.datatypes.entity.User;
import com.clinicapp.libs.constants.TableDefs;

import javax.persistence.*;
import java.io.Serializable;
@NamedQueries({
        @NamedQuery(
                name = QueryTokens.GET_DOCTOR_BY_EMAIL,
                query = "SELECT d FROM Doctor d " +
                        "WHERE d.email = :" + QueryTokens.EMAIL
        )
})
@Entity
@Table(name = TableDefs.TablesNames.DOCTORS)
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
