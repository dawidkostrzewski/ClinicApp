package com.clinicapp.users.api.query.handler.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractQueryHandler;
import com.clinicapp.users.api.query.definition.patient.query.GetPatientShortInfoByIdQuery;
import com.clinicapp.users.api.query.definition.patient.result.GetPatientShortInfoByIdQueryResult;

import javax.ejb.Remote;

@Remote
public interface GetPatientShortInfoByIdQueryHandler extends AbstractQueryHandler<GetPatientShortInfoByIdQueryResult, GetPatientShortInfoByIdQuery, ClinicAppException> {

    String jndi = "ejb:clinic-app-users/GetPatientShortInfoByIdQueryHandlerImpl!com.clinicapp.users.api.query.handler.patient.GetPatientShortInfoByIdQueryHandler";

}
