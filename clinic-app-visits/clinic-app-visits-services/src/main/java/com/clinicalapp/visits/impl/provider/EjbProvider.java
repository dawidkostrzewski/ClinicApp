package com.clinicalapp.visits.impl.provider;

import com.clinicapp.libs.handler.ServiceProvider;
import com.clinicapp.users.api.query.handler.doctor.CheckIfDoctorExistQueryHandler;
import com.clinicapp.users.api.query.handler.doctor.GetDoctorWorkTimesForSelectedDateQueryHandler;
import com.clinicapp.users.api.query.handler.patient.CheckIfPatientExistQueryHandler;
import com.clinicapp.users.api.query.handler.patient.GetPatientShortInfoByIdQueryHandler;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;

@Stateless
@LocalBean
public class EjbProvider {

    @Produces
    public CheckIfDoctorExistQueryHandler getCheckIfDoctorExistQueryHandler() {
        return ServiceProvider.getService(CheckIfDoctorExistQueryHandler.jndi);
    }

    @Produces
    public CheckIfPatientExistQueryHandler getCheckIfPatientExistQueryHandler() {
        return ServiceProvider.getService(CheckIfPatientExistQueryHandler.jndi);
    }

    @Produces
    public GetDoctorWorkTimesForSelectedDateQueryHandler getDoctorWorkTimesForSelectedDateQueryHandler() {
        return ServiceProvider.getService(GetDoctorWorkTimesForSelectedDateQueryHandler.jndi);
    }

    @Produces
    public GetPatientShortInfoByIdQueryHandler getPatientShortInfoByIdQueryHandler() {
        return ServiceProvider.getService(GetPatientShortInfoByIdQueryHandler.jndi);
    }

}
