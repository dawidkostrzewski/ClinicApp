package com.clinicalapp.visits.api.query.handler;

import com.clinicalapp.visits.api.query.definition.query.GetAvailableVisitTimesByDoctorAndPatientIdQuery;
import com.clinicalapp.visits.api.query.definition.result.GetAvailableVisitTimesByDoctorAndPatientIdQueryResult;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractQueryHandler;

import javax.ejb.Remote;

@Remote
public interface GetAvailableVisitTimesByDoctorAndPatientIdQueryHandler extends AbstractQueryHandler<GetAvailableVisitTimesByDoctorAndPatientIdQueryResult, GetAvailableVisitTimesByDoctorAndPatientIdQuery, ClinicAppException> {

    String jndi = "java:global/clinic-app-visits/GetAvailableVisitTimesByDoctorAndPatientIdQueryHandlerImpl!com.clinicalapp.visits.api.query.handler.GetAvailableVisitTimesByDoctorAndPatientIdQueryHandler";

}
