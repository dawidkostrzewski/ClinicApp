package com.clinicalapp.visits.api.query.handler;


import com.clinicalapp.visits.api.query.definition.query.GetVisitListByDoctorIdInSelectedDateQuery;
import com.clinicalapp.visits.api.query.definition.result.GetVisitListByDoctorIdInSelectedDateQueryResult;
import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractQueryHandler;

import javax.ejb.Remote;

@Remote
public interface GetVisitListByDoctorIdInSelectedDateQueryHandler extends AbstractQueryHandler<GetVisitListByDoctorIdInSelectedDateQueryResult, GetVisitListByDoctorIdInSelectedDateQuery, ClinicAppException> {

    String jndi = "java:global/clinic-app-visits/GetVisitListByDoctorIdInSelectedDateQueryHandlerImpl!com.clinicalapp.visits.api.query.handler.GetVisitListByDoctorIdInSelectedDateQueryHandler";

}
