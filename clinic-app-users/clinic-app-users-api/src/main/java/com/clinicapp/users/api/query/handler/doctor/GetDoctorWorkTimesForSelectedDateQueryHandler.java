package com.clinicapp.users.api.query.handler.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractQueryHandler;
import com.clinicapp.users.api.query.definition.doctor.query.GetDoctorWorkTimesForSelectedDateQuery;
import com.clinicapp.users.api.query.definition.doctor.result.GetDoctorWorkTimesForSelectedDateQueryResult;

import javax.ejb.Remote;

@Remote
public interface GetDoctorWorkTimesForSelectedDateQueryHandler extends AbstractQueryHandler<GetDoctorWorkTimesForSelectedDateQueryResult, GetDoctorWorkTimesForSelectedDateQuery, ClinicAppException> {

    String jndi = "java:global/clinic-app-users/GetDoctorWorkTimesForSelectedDateQueryHandlerImpl!com.clinicapp.users.api.query.handler.doctor.GetDoctorWorkTimesForSelectedDateQueryHandler";

}
