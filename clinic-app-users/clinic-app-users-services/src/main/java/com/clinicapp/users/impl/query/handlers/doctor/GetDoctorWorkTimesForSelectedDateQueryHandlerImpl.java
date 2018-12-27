package com.clinicapp.users.impl.query.handlers.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.api.query.definition.doctor.query.GetDoctorWorkTimesForSelectedDateQuery;
import com.clinicapp.users.api.query.definition.doctor.result.GetDoctorWorkTimesForSelectedDateQueryResult;
import com.clinicapp.users.api.query.handler.doctor.GetDoctorWorkTimesForSelectedDateQueryHandler;
import com.clinicapp.users.impl.command.datatypes.aggregate.Doctor;
import com.clinicapp.users.impl.command.repo.doctor.DoctorsRepo;
import com.clinicapp.users.impl.query.domain.doctor.converter.DoctorConverter;
import com.clinicapp.users.impl.query.validation.doctor.GetDoctorWorkTimesForSelectedDateQueryValidator;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class GetDoctorWorkTimesForSelectedDateQueryHandlerImpl implements GetDoctorWorkTimesForSelectedDateQueryHandler {

    @EJB
    private DoctorsRepo doctorsRepo;

    @Override
    public GetDoctorWorkTimesForSelectedDateQueryResult handle(GetDoctorWorkTimesForSelectedDateQuery query) throws ClinicAppException {

        GetDoctorWorkTimesForSelectedDateQueryValidator.validate(query);

        Doctor doctor = doctorsRepo.getById(query.getDoctorId());

        return DoctorConverter.convertToDoctorWorkHours(doctor, query.getDate());
    }
}
