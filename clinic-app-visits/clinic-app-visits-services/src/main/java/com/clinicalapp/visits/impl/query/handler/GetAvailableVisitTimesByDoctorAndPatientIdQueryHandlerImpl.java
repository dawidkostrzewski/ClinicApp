package com.clinicalapp.visits.impl.query.handler;

import com.clinicalapp.visits.api.query.definition.query.GetAvailableVisitTimesByDoctorAndPatientIdQuery;
import com.clinicalapp.visits.api.query.definition.result.GetAvailableVisitTimesByDoctorAndPatientIdQueryResult;
import com.clinicalapp.visits.api.query.handler.GetAvailableVisitTimesByDoctorAndPatientIdQueryHandler;
import com.clinicalapp.visits.impl.command.datatypes.entity.Visit;
import com.clinicalapp.visits.impl.command.repo.visit.VisitRepo;
import com.clinicalapp.visits.impl.query.datatypes.SelectedVisitDay;
import com.clinicalapp.visits.impl.query.domain.converter.VisitConverter;
import com.clinicalapp.visits.impl.query.validation.GetAvailableVisitTimesByDoctorAndPatientIdQueryValidator;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.api.query.definition.doctor.query.CheckIfDoctorExistQuery;
import com.clinicapp.users.api.query.definition.doctor.query.GetDoctorWorkTimesForSelectedDateQuery;
import com.clinicapp.users.api.query.definition.doctor.result.GetDoctorWorkTimesForSelectedDateQueryResult;
import com.clinicapp.users.api.query.definition.patient.query.CheckIfPatientExistQuery;
import com.clinicapp.users.api.query.handler.doctor.CheckIfDoctorExistQueryHandler;
import com.clinicapp.users.api.query.handler.doctor.GetDoctorWorkTimesForSelectedDateQueryHandler;
import com.clinicapp.users.api.query.handler.patient.CheckIfPatientExistQueryHandler;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class GetAvailableVisitTimesByDoctorAndPatientIdQueryHandlerImpl implements GetAvailableVisitTimesByDoctorAndPatientIdQueryHandler {

    @Inject
    private CheckIfPatientExistQueryHandler checkIfPatientExistQueryHandler;

    @Inject
    private CheckIfDoctorExistQueryHandler checkIfDoctorExistQueryHandler;

    @Inject
    private GetDoctorWorkTimesForSelectedDateQueryHandler getDoctorWorkTimesForSelectedDateQueryHandler;

    @EJB
    private VisitRepo visitRepo;

    @Override
    public GetAvailableVisitTimesByDoctorAndPatientIdQueryResult handle(GetAvailableVisitTimesByDoctorAndPatientIdQuery query) throws ClinicAppException {

        GetAvailableVisitTimesByDoctorAndPatientIdQueryValidator.validate(query);

        checkIfDoctorExistQueryHandler.handle(new CheckIfDoctorExistQuery(query.getDoctorId()));

        checkIfPatientExistQueryHandler.handle(new CheckIfPatientExistQuery(query.getPatientId()));

        SelectedVisitDay selectedVisitDay = VisitConverter.getVisitDayFromDate(query.getSelectedDate());

        List<Visit> visitList = visitRepo.getAllVisitsForSelectedDate(query.getPatientId(), query.getDoctorId(), selectedVisitDay.getStart(), selectedVisitDay.getEnd());

        GetDoctorWorkTimesForSelectedDateQueryResult doctorWorkTimes = getDoctorWorkTimesForSelectedDateQueryHandler.handle(new GetDoctorWorkTimesForSelectedDateQuery(query.getDoctorId(), query.getSelectedDate()));

        return VisitConverter.getAvailableVisitTimes(doctorWorkTimes, visitList, query.getSelectedDate());
    }
}
