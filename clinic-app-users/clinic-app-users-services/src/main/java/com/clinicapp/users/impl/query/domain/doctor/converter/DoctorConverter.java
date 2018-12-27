package com.clinicapp.users.impl.query.domain.doctor.converter;

import com.clinicapp.users.api.query.definition.doctor.result.GetDoctorListElementQueryResult;
import com.clinicapp.users.api.query.definition.doctor.result.GetDoctorWorkTimesForSelectedDateQueryResult;
import com.clinicapp.users.api.query.definition.doctor.result.GetDoctorsListQueryResult;
import com.clinicapp.users.api.query.definition.doctor.result.worktime.WorkDayQueryResult;
import com.clinicapp.users.api.query.definition.doctor.result.worktime.WorkDayTimeQueryResult;
import com.clinicapp.users.impl.command.datatypes.aggregate.Doctor;
import com.clinicapp.users.impl.command.datatypes.entity.worktime.WorkDay;
import com.clinicapp.users.impl.command.datatypes.entity.worktime.WorkTime;

import java.util.*;

public class DoctorConverter {

    public static GetDoctorsListQueryResult convertToDoctorsList(List<Doctor> doctors) {


        List<GetDoctorListElementQueryResult> getDoctorsListQueryResultList = new ArrayList<>();

        for(Doctor doctor : doctors) {
            GetDoctorListElementQueryResult element = new GetDoctorListElementQueryResult();

            element.setId(doctor.getId());
            element.setName(doctor.getFamilyName() + " " + doctor.getFirstName());
            element.setSpecialization(doctor.getSpecialization());

            getDoctorsListQueryResultList.add(element);
        }

        return new GetDoctorsListQueryResult(getDoctorsListQueryResultList);
    }

    public static GetDoctorWorkTimesForSelectedDateQueryResult convertToDoctorWorkHours(Doctor doctor, Long time) {

        Date date = new Date(time);
        GetDoctorWorkTimesForSelectedDateQueryResult queryResult = new GetDoctorWorkTimesForSelectedDateQueryResult();
        queryResult.setWorkDayQueryResult(convertWorkDayToResult(getWorkDay(date.getDay(), doctor)));

        return queryResult;

    }

    private static WorkDay getWorkDay(int dayNumber, Doctor doctor) {
        switch (dayNumber) {
            case 0: return doctor.getWorkingHours().getMonday();
            case 1: return doctor.getWorkingHours().getThursday();
            case 2: return doctor.getWorkingHours().getWednesday();
            case 3: return doctor.getWorkingHours().getTuesday();
            case 4: return doctor.getWorkingHours().getFriday();
            case 5: return doctor.getWorkingHours().getSaturday();
            case 6: return doctor.getWorkingHours().getSunday();
            default: return null;
        }
    }

    private static WorkDayQueryResult convertWorkDayToResult(WorkDay workDay) {
        WorkDayQueryResult workDayQueryResult = new WorkDayQueryResult();

        workDayQueryResult.setStartTime(convertWorkTimeToResult(workDay.getStartTime()));
        workDayQueryResult.setEndTime(convertWorkTimeToResult(workDay.getEndTime()));
        workDayQueryResult.setBreakStartTime(convertWorkTimeToResult(workDay.getBreakStartTime()));
        workDayQueryResult.setBreakEndTime(convertWorkTimeToResult(workDay.getBreakEndTime()));

        return workDayQueryResult;
    }

    private static WorkDayTimeQueryResult convertWorkTimeToResult(WorkTime workTime) {
        WorkDayTimeQueryResult workDayTimeQueryResult = new WorkDayTimeQueryResult();

        workDayTimeQueryResult.setHours(workTime.getHour());
        workDayTimeQueryResult.setMinutes(workTime.getMinutes());

        return workDayTimeQueryResult;
    }
}
