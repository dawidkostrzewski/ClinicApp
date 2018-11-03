package com.clinicapp.users.api.query.handler.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractQueryHandler;
import com.clinicapp.users.api.query.definition.patient.query.GetPatientsListQuery;
import com.clinicapp.users.api.query.definition.patient.result.GetPatientsListQueryResult;

import javax.ejb.Remote;

@Remote
public interface GetPatientsListQueryHandler extends AbstractQueryHandler<GetPatientsListQueryResult, GetPatientsListQuery, ClinicAppException> {

    String jndi= "java:app/clinic-app-users/GetPatientsListQueryHandlerImpl!com.clinicapp.users.api.query.handler.patient.GetPatientsListQueryHandler";

}
