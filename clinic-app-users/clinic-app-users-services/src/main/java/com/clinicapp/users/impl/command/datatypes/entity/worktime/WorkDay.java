package com.clinicapp.users.impl.command.datatypes.entity.worktime;

import com.clinicapp.libs.constants.TableDefs;
import com.clinicapp.libs.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = TableDefs.TablesNames.WORK_DAY)
public class WorkDay extends BaseEntity implements Serializable {

    @OneToOne(mappedBy = "workDay", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private WorkTime startTime;

    @OneToOne(mappedBy = "workDay", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private WorkTime endTime;

    @OneToOne(mappedBy = "workDay", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private WorkTime breakStartTime;

    @OneToOne(mappedBy = "workDay", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private WorkTime breakEndTime;

    @OneToOne(cascade = CascadeType.ALL)
    private WorkingHours workingHours;

    public WorkDay() {
    }

    public WorkTime getStartTime() {
        return startTime;
    }

    public void setStartTime(WorkTime startTime) {
        this.startTime = startTime;
    }

    public WorkTime getEndTime() {
        return endTime;
    }

    public void setEndTime(WorkTime endTime) {
        this.endTime = endTime;
    }

    public WorkTime getBreakStartTime() {
        return breakStartTime;
    }

    public void setBreakStartTime(WorkTime breakStartTime) {
        this.breakStartTime = breakStartTime;
    }

    public WorkTime getBreakEndTime() {
        return breakEndTime;
    }

    public void setBreakEndTime(WorkTime breakEndTime) {
        this.breakEndTime = breakEndTime;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }
}