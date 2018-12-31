package com.clinicapp.users.api.query.handler.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractQueryHandler;
import com.clinicapp.users.api.query.definition.doctor.query.CheckIfDoctorExistQuery;

import javax.ejb.Remote;

@Remote
public interface CheckIfDoctorExistQueryHandler extends AbstractQueryHandler<Boolean, CheckIfDoctorExistQuery, ClinicAppException> {

    String jndi = "ejb:clinic-app-users/CheckIfDoctorExistQueryHandlerImpl!com.clinicapp.users.api.query.handler.doctor.CheckIfDoctorExistQueryHandler";

}
