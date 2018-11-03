package com.clinicapp.users.impl.query.handlers.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.api.query.definition.doctor.query.GetDoctorsListQuery;
import com.clinicapp.users.api.query.definition.doctor.result.GetDoctorsListQueryResult;
import com.clinicapp.users.api.query.handler.doctor.GetDoctorsListQueryHandler;
import com.clinicapp.users.impl.command.datatypes.aggregate.Doctor;
import com.clinicapp.users.impl.command.domain.doctor.converter.DoctorConverter;
import com.clinicapp.users.impl.command.repo.doctor.DoctorsRepo;
import com.clinicapp.users.impl.query.validation.doctor.GetDoctorsListQueryValidator;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class GetDoctorsListQueryHandlerImpl implements GetDoctorsListQueryHandler {

    @EJB
    private DoctorsRepo doctorsRepo;

    @Override
    public GetDoctorsListQueryResult handle(GetDoctorsListQuery query) throws ClinicAppException {

        GetDoctorsListQueryValidator.validate(query);

        List<Doctor> doctors = doctorsRepo.getDoctorsList(query);

        return DoctorConverter.convertToDoctorsList(doctors);
    }
}
