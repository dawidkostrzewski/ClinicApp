package com.clinicapp.users.api.query.handler.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractQueryHandler;
import com.clinicapp.users.api.query.definition.doctor.query.GetDoctorsListQuery;
import com.clinicapp.users.api.query.definition.doctor.result.GetDoctorsListQueryResult;

import javax.ejb.Remote;

@Remote
public interface GetDoctorsListQueryHandler extends AbstractQueryHandler<GetDoctorsListQueryResult, GetDoctorsListQuery, ClinicAppException> {

    String jndi = "java:global/clinic-app-users/GetDoctorsListQueryHandlerImpl!com.clinicapp.users.api.query.handler.doctor.GetDoctorsListQueryHandler";

}
