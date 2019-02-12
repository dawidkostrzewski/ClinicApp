package com.clinicalapp.visits.impl.command.datatypes.entity;

import com.clinicalapp.visits.impl.command.datatypes.QueryTokens;
import com.clinicapp.libs.constants.TableDefs;
import com.clinicapp.libs.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@NamedQueries({
        @NamedQuery(
                name = QueryTokens.CheckVisitTimeIsAvailableForPatient,
                query = "SELECT v FROM Visit v " +
                        "WHERE v.patient = :" + QueryTokens.PATIENT_ID + " " +
                        "AND v.time = :" + QueryTokens.VISIT_TIME
        ),
        @NamedQuery(
                name = QueryTokens.CheckVisitTimeIsAvailableForDoctor,
                query = "SELECT v FROM Visit v " +
                        "WHERE v.doctor = :" + QueryTokens.DOCTOR_ID + " " +
                        "AND v.time = :" + QueryTokens.VISIT_TIME
        ),
        @NamedQuery(
                name = QueryTokens.GET_VISITS_IN_SELECTED_DATE_FOR_PATIENT_AND_DOCTOR,
                query = "SELECT v FROM Visit v " +
                        "WHERE v.doctor = :" + QueryTokens.DOCTOR_ID + " " +
                        "OR v.patient = :" + QueryTokens.PATIENT_ID + " " +
                        "AND v.time >= :" + QueryTokens.START_TIME + " " +
                        "AND v.time <= :" + QueryTokens.END_TIME
        ),
        @NamedQuery(
                name = QueryTokens.GET_DOCTOR_VISITS_IN_SELECTED_DATE,
                query = "SELECT v FROM Visit v " +
                        "WHERE v.doctor = :" + QueryTokens.DOCTOR_ID + " " +
                        "AND v.time >= :" + QueryTokens.START_TIME + " " +
                        "AND v.time <= :" + QueryTokens.END_TIME
        )
})
@Entity
@Table(name = TableDefs.TablesNames.VISIT)
public class Visit extends BaseEntity implements Serializable {

    @Column(name = TableDefs.ColumnNames.Visit.DOCTOR)
    private UUID doctor;

    @Column(name = TableDefs.ColumnNames.Visit.PATIENT)
    private UUID patient;

    @Column(name = TableDefs.ColumnNames.Visit.DESCRIPTION, columnDefinition = "text")
    private String description;

    @Column(name = TableDefs.ColumnNames.Visit.TIME)
    private Long time;

    @Column(name = TableDefs.ColumnNames.Visit.FINISHED)
    private Boolean finished;

    public Visit() {
    }

    public UUID getDoctor() {
        return doctor;
    }

    public void setDoctor(UUID doctor) {
        this.doctor = doctor;
    }

    public UUID getPatient() {
        return patient;
    }

    public void setPatient(UUID patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
