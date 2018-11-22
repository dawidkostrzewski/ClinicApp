package com.clinicapp.users.impl.command.datatypes.entity.worktime;

import com.clinicapp.libs.constants.TableDefs;
import com.clinicapp.libs.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = TableDefs.TablesNames.WORK_TIME)
public class WorkTime extends BaseEntity implements Serializable {

    @Column(name = TableDefs.ColumnNames.WorkTime.HOURS)
    private Integer hour;

    @Column(name = TableDefs.ColumnNames.WorkTime.MINUTES)
    private Integer minutes;

    @OneToOne(cascade = CascadeType.ALL)
    private WorkDay workDay;

    public WorkTime() {
    }

    public WorkTime(int hours, int minutes) {
        this.hour = hours;
        this.minutes = minutes;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public WorkDay getWorkDay() {
        return workDay;
    }

    public void setWorkDay(WorkDay workDay) {
        this.workDay = workDay;
    }
}
