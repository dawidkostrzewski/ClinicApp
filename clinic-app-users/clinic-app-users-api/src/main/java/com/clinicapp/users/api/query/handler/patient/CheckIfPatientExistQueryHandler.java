package com.clinicapp.users.api.query.handler.patient;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractQueryHandler;
import com.clinicapp.users.api.query.definition.patient.query.CheckIfPatientExistQuery;

import javax.ejb.Remote;

@Remote
public interface CheckIfPatientExistQueryHandler extends AbstractQueryHandler<Boolean, CheckIfPatientExistQuery, ClinicAppException> {

    String jndi = "ejb:clinic-app-users/CheckIfPatientExistQueryHandlerImpl!com.clinicapp.users.api.query.handler.patient.CheckIfPatientExistQueryHandler";
}
