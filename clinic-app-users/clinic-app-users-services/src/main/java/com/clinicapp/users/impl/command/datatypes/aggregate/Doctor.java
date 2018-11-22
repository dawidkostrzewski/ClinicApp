package com.clinicapp.users.impl.command.datatypes.aggregate;

import com.clinicapp.users.impl.command.datatypes.QueryTokens;
import com.clinicapp.users.impl.command.datatypes.entity.User;
import com.clinicapp.libs.constants.TableDefs;
import com.clinicapp.users.impl.command.datatypes.entity.worktime.WorkingHours;

import javax.persistence.*;
import java.io.Serializable;
@NamedQueries({
        @NamedQuery(
                name = QueryTokens.GET_DOCTOR_BY_EMAIL,
                query = "SELECT d FROM Doctor d " +
                        "WHERE d.email = :" + QueryTokens.EMAIL
        ),
        @NamedQuery(
                name = QueryTokens.GET_DOCTORS_LIST,
                query = "SELECT d FROM Doctor d " +
                        "ORDER BY d.familyName DESC "
        )
})
@Entity
@Table(name = TableDefs.TablesNames.DOCTORS)
public class Doctor extends User implements Serializable {

    @Column(name = TableDefs.ColumnNames.Doctor.SPECIALIZATION)
    private String specialization;

    @OneToOne(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private WorkingHours workingHours;

    public Doctor() {
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }
}
