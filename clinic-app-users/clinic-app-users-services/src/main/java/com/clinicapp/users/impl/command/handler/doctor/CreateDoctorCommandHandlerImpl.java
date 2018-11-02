package com.clinicapp.users.impl.command.handler.doctor;

import com.clinicapp.libs.exceptions.ClinicAppException;
import com.clinicapp.users.api.command.definition.doctor.CreateDoctorCommand;
import com.clinicapp.users.api.command.handler.doctor.CreateDoctorCommandHandler;
import com.clinicapp.users.impl.command.datatypes.aggregate.Doctor;
import com.clinicapp.users.impl.command.domain.doctor.factory.DoctorFactory;
import com.clinicapp.users.impl.command.validation.doctor.CreateDoctorCommandValidator;

import javax.ejb.Stateless;
import java.util.UUID;

@Stateless
public class CreateDoctorCommandHandlerImpl implements CreateDoctorCommandHandler {

    @Override
    public UUID handle(CreateDoctorCommand command) throws ClinicAppException {

        CreateDoctorCommandValidator.validate(command);

        //TODO CHECK IF DOCTOR EMAIL IS UNIQUE

        Doctor doctor = DoctorFactory.create(command);

        return doctor.getId();
    }
}
