package com.clinicapp.users.api.command.definition.doctor;

import com.clinicapp.users.api.query.definition.doctor.result.worktime.WorkHoursQueryResult;

import java.io.Serializable;

public class CreateDoctorCommand implements Serializable {

    private String firstName;

    private String familyName;

    private String email;

    private String specialization;

    private WorkHoursQueryResult workingHours;

    public CreateDoctorCommand() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public WorkHoursQueryResult getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkHoursQueryResult workingHours) {
        this.workingHours = workingHours;
    }
}
