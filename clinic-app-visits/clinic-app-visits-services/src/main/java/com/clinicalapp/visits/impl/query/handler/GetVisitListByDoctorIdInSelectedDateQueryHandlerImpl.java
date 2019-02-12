package com.clinicalapp.visits.impl.query.handler;

import com.clinicalapp.visits.api.query.definition.query.GetVisitListByDoctorIdInSelectedDateQuery;
import com.clinicalapp.visits.api.query.definition.result.GetVisitListByDoctorIdInSelectedDateQueryElement;
import com.clinicalapp.visits.api.query.definition.result.GetVisitListByDoctorIdInSelectedDateQueryResult;
import com.clinicalapp.visits.api.query.handler.GetVisitListByDoctorIdInSelectedDateQueryHandler;
import com.clinicalapp.visits.impl.command.datatypes.entity.Visit;
import com.clinicalapp.visits.impl.command.repo.visit.VisitRepo;
import com.clinicalapp.visits.impl.query.datatypes.SelectedVisitDay;
import com.clinicalapp.visits.impl.query.domain.converter.VisitConverter;
import com.clinicalapp.visits.impl.query.validation.GetVisitListByDoctorIdInSelectedDateQueryValidator;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.api.query.definition.doctor.query.CheckIfDoctorExistQuery;
import com.clinicapp.users.api.query.definition.patient.query.GetPatientShortInfoByIdQuery;
import com.clinicapp.users.api.query.handler.doctor.CheckIfDoctorExistQueryHandler;
import com.clinicapp.users.api.query.handler.patient.GetPatientShortInfoByIdQueryHandler;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class GetVisitListByDoctorIdInSelectedDateQueryHandlerImpl implements GetVisitListByDoctorIdInSelectedDateQueryHandler {

    @Inject
    private CheckIfDoctorExistQueryHandler checkIfDoctorExistQueryHandler;

    @Inject
    private GetPatientShortInfoByIdQueryHandler getPatientShortInfoByIdQueryHandler;

    @EJB
    private VisitRepo visitRepo;

    @Override
    public GetVisitListByDoctorIdInSelectedDateQueryResult handle(GetVisitListByDoctorIdInSelectedDateQuery query) throws ClinicAppException {

        GetVisitListByDoctorIdInSelectedDateQueryValidator.validate(query);

        checkIfDoctorExistQueryHandler.handle(new CheckIfDoctorExistQuery(query.getDoctorId()));

        SelectedVisitDay selectedVisitDay = VisitConverter.getVisitDayFromDate(query.getSelectedDate());

        List<Visit> visitList = visitRepo.getAllDoctorVisitInSelectedDate(query.getDoctorId(), selectedVisitDay.getStart(), selectedVisitDay.getEnd());

        GetVisitListByDoctorIdInSelectedDateQueryResult queryResult = VisitConverter.getVisitListByDoctorIdInSelectedDateQueryResult();

        for(Visit visit : visitList) {

            queryResult.getVisits().add(VisitConverter.getVisitListByDoctorIdInSelectedDateQueryResult(
                    getPatientShortInfoByIdQueryHandler.handle(new GetPatientShortInfoByIdQuery(visit.getPatient())),visit));
        }

        return queryResult;
    }
}
