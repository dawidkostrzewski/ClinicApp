package com.clinicapp.users.impl.command.datatypes.entity.worktime;

import com.clinicapp.libs.constants.TableDefs;
import com.clinicapp.libs.entity.BaseEntity;
import com.clinicapp.users.impl.command.datatypes.aggregate.Doctor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = TableDefs.TablesNames.WORKING_HOURS)
public class WorkingHours extends BaseEntity implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

    @OneToOne(mappedBy = "workingHours", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private WorkDay monday;

    @OneToOne(mappedBy = "workingHours", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private WorkDay tuesday;

    @OneToOne(mappedBy = "workingHours", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private WorkDay wednesday;

    @OneToOne(mappedBy = "workingHours", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private WorkDay thursday;

    @OneToOne(mappedBy = "workingHours", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private WorkDay friday;

    @OneToOne(mappedBy = "workingHours", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private WorkDay saturday;

    @OneToOne(mappedBy = "workingHours", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private WorkDay sunday;

    public WorkingHours() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public WorkDay getMonday() {
        return monday;
    }

    public void setMonday(WorkDay monday) {
        this.monday = monday;
    }

    public WorkDay getTuesday() {
        return tuesday;
    }

    public void setTuesday(WorkDay tuesday) {
        this.tuesday = tuesday;
    }

    public WorkDay getWednesday() {
        return wednesday;
    }

    public void setWednesday(WorkDay wednesday) {
        this.wednesday = wednesday;
    }

    public WorkDay getThursday() {
        return thursday;
    }

    public void setThursday(WorkDay thursday) {
        this.thursday = thursday;
    }

    public WorkDay getFriday() {
        return friday;
    }

    public void setFriday(WorkDay friday) {
        this.friday = friday;
    }

    public WorkDay getSaturday() {
        return saturday;
    }

    public void setSaturday(WorkDay saturday) {
        this.saturday = saturday;
    }

    public WorkDay getSunday() {
        return sunday;
    }

    public void setSunday(WorkDay sunday) {
        this.sunday = sunday;
    }
}
