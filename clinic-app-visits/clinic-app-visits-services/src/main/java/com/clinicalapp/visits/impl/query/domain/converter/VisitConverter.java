package com.clinicalapp.visits.impl.query.domain.converter;


import com.clinicalapp.visits.api.query.definition.result.GetAvailableVisitTimesByDoctorAndPatientIdQueryResult;
import com.clinicalapp.visits.api.query.definition.result.GetVisitListByDoctorIdInSelectedDateQueryElement;
import com.clinicalapp.visits.api.query.definition.result.GetVisitListByDoctorIdInSelectedDateQueryResult;
import com.clinicalapp.visits.impl.command.datatypes.entity.Visit;
import com.clinicalapp.visits.impl.query.datatypes.SelectedVisitDay;
import com.clinicapp.users.api.query.definition.doctor.result.GetDoctorWorkTimesForSelectedDateQueryResult;
import com.clinicapp.users.api.query.definition.patient.result.GetPatientShortInfoByIdQueryResult;
import org.joda.time.DateTime;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class VisitConverter {

    private final static Long PATIENT_VISIT_DURATION = 900000L;

    public static SelectedVisitDay getVisitDayFromDate(Long selectedDate) {
        SelectedVisitDay selectedVisitDay = new SelectedVisitDay();

        DateTime startTime = new DateTime(selectedDate)
                .withHourOfDay(0)
                .withMinuteOfHour(0)
                .withSecondOfMinute(0)
                .withMillisOfSecond(0);

        DateTime endTime = new DateTime(selectedDate)
                .withHourOfDay(23)
                .withMinuteOfHour(59)
                .withSecondOfMinute(59)
                .withMillisOfSecond(999);

        selectedVisitDay.setStart(startTime.getMillis());
        selectedVisitDay.setEnd(endTime.getMillis());

        return selectedVisitDay;
    }

    public static GetAvailableVisitTimesByDoctorAndPatientIdQueryResult getAvailableVisitTimes(GetDoctorWorkTimesForSelectedDateQueryResult workTime, List<Visit> visitList, Long selectedDate) {

        GetAvailableVisitTimesByDoctorAndPatientIdQueryResult queryResult = new GetAvailableVisitTimesByDoctorAndPatientIdQueryResult();
        Set<Long> availableVisits = new HashSet<>();
        DateTime breakStart = null;
        DateTime breakEnd = null;
        if(workTime != null && workTime.getWorkDayQueryResult() != null
                && workTime.getWorkDayQueryResult().getStartTime() != null){

            DateTime visitTime = new DateTime(selectedDate)
                    .withHourOfDay(workTime.getWorkDayQueryResult().getStartTime().getHours())
                    .withMinuteOfHour(workTime.getWorkDayQueryResult().getStartTime().getMinutes())
                    .withSecondOfMinute(0)
                    .withMillisOfSecond(0);

            if(workTime.getWorkDayQueryResult().getBreakStartTime() != null) {
                breakStart = new DateTime(selectedDate)
                        .withHourOfDay(workTime.getWorkDayQueryResult().getBreakStartTime().getHours())
                        .withMinuteOfHour(workTime.getWorkDayQueryResult().getBreakStartTime().getMinutes())
                        .withSecondOfMinute(0)
                        .withMillisOfSecond(0);
            }

            if(workTime.getWorkDayQueryResult().getBreakEndTime() != null) {
                breakEnd = new DateTime(selectedDate)
                        .withHourOfDay(workTime.getWorkDayQueryResult().getBreakEndTime().getHours())
                        .withMinuteOfHour(workTime.getWorkDayQueryResult().getBreakEndTime().getMinutes())
                        .withSecondOfMinute(0)
                        .withMillisOfSecond(0);
            }

            DateTime endTime = new DateTime(selectedDate)
                    .withHourOfDay(workTime.getWorkDayQueryResult().getEndTime().getHours())
                    .withMinuteOfHour(workTime.getWorkDayQueryResult().getEndTime().getMinutes())
                    .withSecondOfMinute(0)
                    .withMillisOfSecond(0);

            while (visitTime.getMillis() <= endTime.getMillis()) {

                if((breakStart != null && breakEnd != null)
                        && visitTime.getMillis() < breakStart.getMillis()
                        && visitTime.getMillis() > breakEnd.getMillis()) {

                    if(!checkIfTimeIsOnVisitList(visitList, visitTime.getMillis())) {
                        availableVisits.add(visitTime.getMillis());
                    }
                }

                visitTime = new DateTime(visitTime.getMillis() + PATIENT_VISIT_DURATION);
            }
        }

        queryResult.setAvailableVisitTimes(availableVisits);

        return queryResult;
    }

    public static GetVisitListByDoctorIdInSelectedDateQueryElement getVisitListByDoctorIdInSelectedDateQueryResult(GetPatientShortInfoByIdQueryResult patient, Visit visit) {

        GetVisitListByDoctorIdInSelectedDateQueryElement queryResult = new GetVisitListByDoctorIdInSelectedDateQueryElement();

        queryResult.setPatientId(patient.getId());
        queryResult.setVisitId(visit.getId());
        queryResult.setPatientName(patient.getFamilyName() + " " + patient.getFirstName());
        queryResult.setPatientIdentificationNumber(patient.getIdentificationNumberType() + ": " + patient.getIdentificationNumberValue());
        queryResult.setVisitTime(visit.getTime());
        queryResult.setFinished(visit.getFinished());

        return queryResult;
    }

    public static GetVisitListByDoctorIdInSelectedDateQueryResult getVisitListByDoctorIdInSelectedDateQueryResult() {
        GetVisitListByDoctorIdInSelectedDateQueryResult queryResult = new GetVisitListByDoctorIdInSelectedDateQueryResult();

        queryResult.setVisits(new HashSet<>());

        return queryResult;
    }

    private static Boolean checkIfTimeIsOnVisitList(List<Visit> visitList, Long visitTime) {
        for(Visit visit : visitList) {
            if(visit.getTime().equals(visitTime)) {
                return true;
            }
        }
        return false;
    }
}
