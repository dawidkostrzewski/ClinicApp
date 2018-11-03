package com.clinicapp.users.impl.query.handlers.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.libs.handler.AbstractHandler;
import com.clinicapp.users.api.query.definition.doctor.query.CheckIfDoctorExistQuery;
import com.clinicapp.users.api.query.handler.doctor.CheckIfDoctorExistQueryHandler;
import com.clinicapp.users.impl.command.datatypes.aggregate.Doctor;
import com.clinicapp.users.impl.command.repo.doctor.DoctorsRepo;
import com.clinicapp.users.impl.query.validation.doctor.CheckIfDoctorExistQueryValidator;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CheckIfDoctorExistHandlerImpl extends AbstractHandler<Doctor> implements CheckIfDoctorExistQueryHandler {

    @EJB
    private DoctorsRepo doctorsRepo;

    @Override
    public Boolean handle(CheckIfDoctorExistQuery query) throws ClinicAppException {

        CheckIfDoctorExistQueryValidator.validate(query);

        Doctor doctor = doctorsRepo.getById(query.getDoctorId());

        checkIfExist(doctor);

        return true;
    }
}
