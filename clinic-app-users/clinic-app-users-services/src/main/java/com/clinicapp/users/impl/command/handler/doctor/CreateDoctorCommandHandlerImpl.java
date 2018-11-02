package com.clinicapp.users.impl.command.handler.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.api.command.definition.doctor.CreateDoctorCommand;
import com.clinicapp.users.api.command.handler.doctor.CreateDoctorCommandHandler;
import com.clinicapp.users.impl.command.domain.doctor.factory.DoctorFactory;
import com.clinicapp.users.impl.command.repo.doctor.DoctorsRepo;
import com.clinicapp.users.impl.command.validation.doctor.CreateDoctorCommandValidator;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.UUID;

@Stateless
public class CreateDoctorCommandHandlerImpl implements CreateDoctorCommandHandler {

    @EJB
    private DoctorsRepo doctorsRepo;

    @Override
    public UUID handle(CreateDoctorCommand command) throws ClinicAppException {

        CreateDoctorCommandValidator.validate(command);

        doctorsRepo.checkDoctorEmailUnique(command.getEmail());

        return doctorsRepo.save(DoctorFactory.create(command));
    }
}
