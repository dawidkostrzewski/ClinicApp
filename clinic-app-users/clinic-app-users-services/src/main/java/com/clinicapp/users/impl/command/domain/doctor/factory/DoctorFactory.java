package com.clinicapp.users.impl.command.domain.doctor.factory;

import com.clinicapp.libs.constants.Role;
import com.clinicapp.users.api.command.definition.doctor.CreateDoctorCommand;
import com.clinicapp.users.impl.command.datatypes.aggregate.Doctor;
import com.clinicapp.users.impl.command.datatypes.entity.worktime.WorkDay;
import com.clinicapp.users.impl.command.datatypes.entity.worktime.WorkTime;
import com.clinicapp.users.impl.command.datatypes.entity.worktime.WorkingHours;
import com.clinicapp.users.impl.command.domain.PasswordGenerator;

import static com.clinicapp.libs.constants.Constants.DOCTOR_PERMISSIONS;
import static com.clinicapp.libs.constants.Constants.PASSWORD_LENGTH;

public class DoctorFactory {

    public static Doctor create(CreateDoctorCommand command) {

        Doctor doctor = new Doctor();

        //GENERAL INFO
        doctor.setFirstName(command.getFirstName());
        doctor.setFamilyName(command.getFamilyName());
        doctor.setSpecialization(command.getSpecialization());

        //ACCOUNT SETTINGS
        doctor.setEmail(command.getEmail());
        doctor.setLogin(command.getEmail());
        doctor.setPassword(PasswordGenerator.generate(PASSWORD_LENGTH));
        doctor.setRole(Role.DOCTOR);
        doctor.setCreationTime(System.currentTimeMillis());
        doctor.setPermissions(DOCTOR_PERMISSIONS);

        //WORK HOURS
        doctor.setWorkingHours(createWorkingHours(command));
        doctor.getWorkingHours().setDoctor(doctor);

        return doctor;
    }

    private static WorkDay createWorkDay(com.clinicapp.users.api.query.definition.doctor.result.worktime.WorkDay workDayData, WorkingHours workingHours) {
        WorkDay workDay = new WorkDay();

        workDay.setStartTime(new WorkTime(workDayData.getStartTime().getHours(), workDayData.getStartTime().getMinutes()));
        workDay.getStartTime().setWorkDay(workDay);

        workDay.setEndTime(new WorkTime(workDayData.getEndTime().getHours(), workDayData.getEndTime().getMinutes()));
        workDay.getEndTime().setWorkDay(workDay);

        workDay.setBreakStartTime(new WorkTime(workDayData.getBreakStartTime().getHours(),workDayData.getBreakStartTime().getMinutes()));
        workDay.getBreakStartTime().setWorkDay(workDay);

        workDay.setBreakEndTime(new WorkTime(workDayData.getBreakEndTime().getHours(), workDayData.getBreakEndTime().getMinutes()));
        workDay.getBreakEndTime().setWorkDay(workDay);

        workDay.setWorkingHours(workingHours);

        return workDay;
    }

    private static WorkingHours createWorkingHours(CreateDoctorCommand command) {
        WorkingHours workingHours = new WorkingHours();

        workingHours.setMonday(createWorkDay(command.getWorkingHours().getMonday(), workingHours));
        workingHours.setTuesday(createWorkDay(command.getWorkingHours().getTuesday(), workingHours));
        workingHours.setWednesday(createWorkDay(command.getWorkingHours().getWednesday(), workingHours));
        workingHours.setThursday(createWorkDay(command.getWorkingHours().getThursday(), workingHours));
        workingHours.setFriday(createWorkDay(command.getWorkingHours().getFriday(), workingHours));
        workingHours.setSaturday(createWorkDay(command.getWorkingHours().getSaturday(), workingHours));
        workingHours.setSunday(createWorkDay(command.getWorkingHours().getSunday(), workingHours));

        return workingHours;

    }
}
